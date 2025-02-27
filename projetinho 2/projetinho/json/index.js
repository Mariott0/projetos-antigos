// import dado from './dados_compras.json'
const dado = require('./dados_compras.json')

console.log(
    dado.length
)

// const julio = dado.filter(p => p.name == 'João Lucas Silva')
// console.log(julio.length)


// var listaPessoa = []

// for (const p of dado) {
//     console.log(p)
    
//     listaPessoa.fin

// }

// const lista = [

//     { "password": "Wh6WhINg9sUqzef", "name": "Júlio Oliveira", "phone": "(60) 37752-3535", "date": "2021-07-16T17:45:11.843Z", "birthdate": "1976-01-15T23:31:19.125Z", "itens": [{ "item": "Cortina blackout", "price": 100 }, { "item": "Equipamentos de segurança", "price": 250 }, { "item": "Luvas de limpeza", "price": 5 }, { "item": "Caderno de anotações", "price": 12 }, { "item": "Pasta", "price": 15 }, { "item": "Banheiro", "price": 500 }, { "item": "Organizadores de documentos", "price": 30 }, { "item": "Liquidificador", "price": 200 }, { "item": "Móvel de TV", "price": 400 }, { "item": "Papel de presente", "price": 3 }, { "item": "Revistas", "price": 5 }, { "item": "Sensores de movimento", "price": 50 }, { "item": "Produtos de higiene", "price": 20 }, { "item": "Máquina de café", "price": 200 }, { "item": "Carregador", "price": 30 }, { "item": "Régua", "price": 5 }, { "item": "Luminárias de mesa", "price": 30 }, { "item": "Mesas", "price": 120 }, { "item": "Teclado mecânico", "price": 200 }, { "item": "Régua", "price": 5 }, { "item": "Esmalte", "price": 8 }, { "item": "Peças de reposição", "price": 50 }, { "item": "Camas de solteiro", "price": 500 }], "interest": [{ "item": "Compasso", "price": 5 }, { "item": "Cadeiras de jantar", "price": 200 }, { "item": "Webcam", "price": 80 }, { "item": "Secadoras de roupa", "price": 600 }, { "item": "Móveis de jardim", "price": 300 }, { "item": "Revistas", "price": 5 }, { "item": "Reprodutores de DVD", "price": 150 }, { "item": "Perfumes", "price": 200 }], "city": "Barros do Norte", "address": "390 Oliveira Alameda Casa 9" },
//     { "password": "mBKcN0KFPZn9lmc", "name": "João Lucas Silva", "phone": "(22) 56172-3636", "date": "2021-09-10T00:45:51.009Z", "birthdate": "1977-07-22T08:16:10.232Z", "itens": [{ "item": "Concha", "price": 10 }, { "item": "Difusores", "price": 25 }, { "item": "Bebidas energéticas", "price": 15 }, { "item": "Manga de confeitar", "price": 20 }, { "item": "Móveis moduláveis", "price": 700 }, { "item": "Luminárias de parede", "price": 150 }, { "item": "Roupas de inverno", "price": 200 }, { "item": "Panela elétrica", "price": 300 }, { "item": "Cortadores de grama", "price": 300 }, { "item": "Aromatizantes", "price": 10 }, { "item": "Máquinas de corte", "price": 300 }, { "item": "Fertilizantes", "price": 15 }, { "item": "Papelaria", "price": 15 }, { "item": "Colchões", "price": 500 }, { "item": "Roteadores", "price": 80 }, { "item": "Equipamentos de proteção", "price": 150 }, { "item": "Cortador de papel", "price": 20 }, { "item": "Papelaria", "price": 15 }, { "item": "Bolsas de viagem", "price": 150 }, { "item": "Colchões de solteiro", "price": 300 }, { "item": "Transferidor", "price": 4 }, { "item": "Óculos de natação", "price": 25 }, { "item": "Fritadeira", "price": 200 }, { "item": "Bolsas de academia", "price": 30 }, { "item": "Carrinhos de bebê", "price": 200 }, { "item": "Iluminação", "price": 60 }, { "item": "Roupa de yoga", "price": 50 }, { "item": "Panos de limpeza", "price": 15 }, { "item": "Pasta sanfonada", "price": 12 }, { "item": "Travesseiro", "price": 25 }, { "item": "Arroz", "price": 2 }, { "item": "Confetes", "price": 5 }, { "item": "Fita crepe", "price": 4 }, { "item": "Papel", "price": 10 }, { "item": "Organizadores de mesa", "price": 25 }, { "item": "Roupas para pets", "price": 20 }, { "item": "Pasta", "price": 15 }, { "item": "Cadeiras de bebê", "price": 80 }, { "item": "Roteadores", "price": 80 }, { "item": "Cortadores de grama", "price": 300 }, { "item": "Brinquedos de empurrar", "price": 50 }, { "item": "Lanterna", "price": 15 }, { "item": "Lanterna", "price": 25 }, { "item": "Bolsas", "price": 100 }, { "item": "Creme anti-idade", "price": 80 }], "interest": [{ "item": "Capa de sofá", "price": 50 }, { "item": "Fitas adesivas", "price": 5 }, { "item": "Diários", "price": 10 }], "city": "Reis do Sul", "address": "38139 Xavier Travessa Lote 89" },

// ]

// console.log(
//     lista.length
// )