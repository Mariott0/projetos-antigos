function sleep(ms) {
    return new Promise(p => setTimeout(p, [ms]))
}

async function go() {
    console.log('1')
    console.log('2')
    await sleep(1000).then(() => console.log(3))
    console.log('4')
}

go()

// quando se consome uma promise  ou um servico externo
// costumase ter um delay na resposta 
// e precisamos esperar o retorno para prosseguir.
// utilizando async await
