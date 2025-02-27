

var a = 0
const b = "teste"
let c = 0.001

// System.out.print(a)

console.log(a, b, c)

const soma = a + b
console.log(soma)

const outrasoma = a + c
console.log(outrasoma)

function Soma(valor1, valor2) {
    return valor1 + valor2
}

console.log(
    Soma(10, 50)
)
console.log(
    Soma(10, 'aksdoaskdo')
)

// no java

// for (int = 0; i < 10; i++) {
// }

for (var i = 0; i < 10; i++) {
    console.log({ valor: i + b })
}