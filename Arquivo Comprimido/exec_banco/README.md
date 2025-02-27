
# criar projeto node

npm init -y

# instalando dependencias do proejto

npm i pg knex
npm install pg knex

# configurando banco de dados no arquivo de conexao

const knex = require('knex');

const db = knex({
  client: 'pg',  
  connection: {
    host: '127.0.0.1',
    user: 'seu_usuario',
    password: 'sua_senha',
    database: 'nome_do_banco'
  }
});

module.exports = db;