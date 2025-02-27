// importo a dependecia do knex para conectar com banco.
const knex = require('knex');

// crio uma classe que sera responsavel pela conexao com o banco
const db = knex({
    client: 'pg',
    connection: {
        host: 'localhost',
        user: 'postgres',
        password: 'root',
        database: 'dados'
    }
});

const lista_compras = require('./dados_compras.json')


async function go() {
//     const dado = await db.raw('select * from cliente limit 2')

//     console.log(dado.rows)
// return
    // inserir um cliente

    // insert into cliente (nome,sobrenome,email,telefone, data_nascimento)
    // values ('teste','teste','teste','teste',now())
    // await db('cliente').insert({
    //     nome: 'joao',
    //     email: "joao@email",
    //     sobrenome: 'sobrenome',
    //     telefone: `1232189`,
    //     data_nascimento: new Date()
    // })

    // const cliente = await db('cliente').where({ id: 1 }).first()
    // json
    // console.log(cliente[0].nome)


    // console.log(cliente)

    // for (const compra of lista_compras) {
    //     console.log(compra.name)
    // }


    //#region  exemplo inserindo um
    // const primeiro = lista_compras[0]

    // const nomes = primeiro.name.split(' ')
    // const nome = nomes[0]
    // const sobrenome = nomes[nomes.length - 1]

    // console.log(primeiro.name)
    // const existe = await db('cliente').where({
    //     nome: nome,
    //     sobrenome: sobrenome
    // }).first()
    // // select * from cliente where nome = 'Júlio' and sobrenome = 'Oliveira' limit 1
    // console.log(existe == null)
    // if (existe == null) {
    //     await db('cliente').insert({
    //         nome: nome,
    //         sobrenome: sobrenome,
    //         email: `${nome}.${sobrenome}@email.com`,
    //         telefone: primeiro.phone,
    //         data_nascimento: primeiro.birthdate
    //     }).then(() => console.log('inseriu'))
    // }
    //#endregion



    for (const item_lista of lista_compras) {

        const nomes = item_lista.name.split(' ')
        const nome = nomes[0]
        const sobrenome = nomes[nomes.length - 1]

        console.log(item_lista.name)
        let cliente = await db('cliente').where({
            nome: nome,
            sobrenome: sobrenome
        }).first()
        // select * from cliente where nome = 'Júlio' and sobrenome = 'Oliveira' limit 1
        console.log(cliente == null)
        if (cliente == null) {
            await db('cliente').insert({
                nome: nome,
                sobrenome: sobrenome,
                email: `${nome}.${sobrenome}@email.com`,
                telefone: item_lista.phone,
                data_nascimento: item_lista.birthdate
            }).then((e) => console.log('inseriu', e))
            cliente = await db('cliente').where({
                nome: nome,
                sobrenome: sobrenome
            }).first()
            if (cliente == null)
                throw ('Nao encontrou')
        }

        // criar um pedido 
        // preciso ter o total dos valores
        let total = 0
        item_lista.itens.forEach(element => {
            total += element.price
        });


        // existe um pedido deste cliente nesta data?

        let pedido = await db('pedido').where({
            cliente_id: cliente.id,
            data_pedido: item_lista.date
        })

        if (pedido == null) {
            await db('pedido').insert({
                cliente_id: cliente.id,
                data_pedido: item_lista.date,
                total_pedido: total
            })
            pedido = await db('pedido').where({
                cliente_id: cliente.id,
                data_pedido: item_lista.date
            })
            if (pedido == null)
                throw ('pedido nao encontrado')

            // item_lista.itens.forEach(item => {
            //     db('itens_pedido').insert({
            //         pedido_id: pedido.id,
            //         quantidade: 1,
            //         preco: item.price,
            //         // produto_id: ???
            //     })
            // })
        }




        // throw ('da erro ai' + cliente.id)


    }
}


go()