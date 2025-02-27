const express = require('express');
const knex = require('knex');
const bcrypt = require('bcrypt');
const app = express();

// Middleware para analisar JSON
app.use(express.json());
app.use(express.static('public')); // Adicione esta linha para servir arquivos estáticos

// Conectar ao banco de dados PostgreSQL
const db = knex({
    client: 'pg',
    connection: {
        host: 'localhost',
        user: 'postgres',
        password: 'root',
        database: 'filmes_db'
    }
});

// Rota para registrar usuário
app.post('/register', async (req, res) => {
    const { nome, email, username, password } = req.body;
    const saltRounds = 10;
    const hashedPassword = await bcrypt.hash(password, saltRounds);

    try {
        await db('usuarios').insert({
            nome,
            email,
            username,
            password: hashedPassword
        });
        res.json({ success: true });
    } catch (error) {
        res.json({ success: false, error: error.message });
    }
});

// Rota para login
app.post('/login', async (req, res) => {
    const { username, password } = req.body;
    const user = await db('usuarios').where({ username }).first();

    if (user && bcrypt.compareSync(password, user.password)) {
        res.json({ success: true });
    } else {
        res.json({ success: false });
    }
});

// Iniciar servidor
app.listen(3002, () => {
    console.log('Servidor rodando na porta 3002');
});
