alert("Boas Vindas ao jogo do numero secreto!");
let numeroSecreto = 4;
console.log(numeroSecreto)
let chute = prompt("Escolha um numero entre 1 e 10");

if (numeroSecreto == chute){
    alert("isso ai! voce descobriu o numero secreto: "+ numeroSecreto);
}else {
    alert("Voce errou!");

}