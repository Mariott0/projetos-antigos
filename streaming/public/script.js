// Função para registrar usuário
const registerUser = async () => {
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const username = document.getElementById('register-username').value;
    const password = document.getElementById('register-password').value;

    const response = await fetch('/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, email, username, password })
    });

    const result = await response.json();
    if (result.success) {
        alert('Usuário registrado com sucesso!');
        window.location.href = 'index.html'; // Redireciona para a página de login
    } else {
        alert('Falha no registro! ' + result.error);
    }
};

// Função para login de usuário
const loginUser = async () => {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const response = await fetch('/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    });

    const result = await response.json();
    if (result.success) {
        alert('Login realizado com sucesso!');
        window.location.href = 'filmes.html'; // Redireciona para a página de filmes
    } else {
        alert('Falha no login! Verifique suas credenciais.');
    }
};
