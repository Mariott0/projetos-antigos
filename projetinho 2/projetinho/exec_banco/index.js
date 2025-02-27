// Importo a dependência do knex para conectar com o banco
const knex = require('knex');
const fs = require('fs');
const path = require('path');

// Crio uma classe que será responsável pela conexão com o banco
const db = knex({
    client: 'pg',
    connection: {
        host: 'localhost',
        user: 'postgres',
        password: 'root',
        database: 'dados'
    }
});

// Caminho da pasta onde estão os arquivos de compras
const folderPath = path.join(__dirname, 'dados_compras');

// Função para listar todos os arquivos da pasta
function listarArquivos() {
    fs.readdir(folderPath, (err, files) => {
        if (err) {
            console.error('Erro ao ler a pasta:', err);
            return;
        }

        // Filtra apenas arquivos JSON
        const arquivosJson = files.filter(file => path.extname(file) === '.json');

        console.log('Arquivos JSON encontrados:');
        arquivosJson.forEach(file => {
            console.log(file);
        });
    });
}

// Chama a função para listar os arquivos
listarArquivos();

// Importa a lista de compras do arquivo JSON
const lista_compras = require('./dados_compras/dados_compras.json');

async function go() {
    for (const item_lista of lista_compras) {
        const nomes = item_lista.name.split(' ');
        const nome = nomes[0];
        const sobrenome = nomes[nomes.length - 1];

        console.log(item_lista.name);
        
        // Verifica se o cliente já existe
        let cliente = await db('cliente').where({
            nome: nome,
            sobrenome: sobrenome
        }).first();

        // Se o cliente não existir, insira
        if (!cliente) {
            await db('cliente').insert({
                nome: nome,
                sobrenome: sobrenome,
                email: `${nome}.${sobrenome}@gmail.com`,
                telefone: item_lista.phone,
                data_nascimento: item_lista.birthdate
            });
            cliente = await db('cliente').where({
                nome: nome,
                sobrenome: sobrenome
            }).first();
        }

        // Calcular o total do pedido
        const total = item_lista.itens.reduce((acc, item) => acc + item.price, 0);

        // Verifica se o pedido já existe
        let pedido = await db('pedido').where({
            cliente_id: cliente.id,
            data_pedido: item_lista.date
        }).first();

        // Se o pedido não existir, insira
        if (!pedido) {
            await db('pedido').insert({
                cliente_id: cliente.id,
                data_pedido: item_lista.date,
                total_pedido: total
            });
            pedido = await db('pedido').where({
                cliente_id: cliente.id,
                data_pedido: item_lista.date
            }).first();
        }

        // Inserir produtos e itens do pedido
        for (const item of item_lista.itens) {
            let produto = await db('produto').where({ nome: item.item }).first();
            
            // Se o produto não existir, insira e recupere o ID do novo produto
            if (!produto) {
                const [produtoId] = await db('produto').insert({
                    nome: item.item,
                    descricao: '',  // Descrição pode ser ajustada
                    preco: item.price
                }).returning('id');  // Retorna o ID do produto inserido
                
                produto = { id: produtoId };  // Define o ID do produto recém-criado
            }

            // Inserir itens do pedido
            await db('itens_pedido').insert({
                pedido_id: pedido.id,
                produto_id: produto.id,  // Agora temos o ID do produto
                quantidade: 1  // A quantidade pode ser ajustada conforme necessário
            });
        }
    }
}

// Executa a função go
go().catch(error => {
    console.error("Erro ao inserir os dados:", error);
}).finally(() => {
    db.destroy(); // Fecha a conexão com o banco ao final
});
