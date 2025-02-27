document.getElementById('productForm').addEventListener('submit', function(e) {
    e.preventDefault();

    // Obtém os valores dos campos
    let nomeProduto = document.getElementById('nomeProduto').value;
    let descricaoProduto = document.getElementById('descricaoProduto').value;
    let precoCusto = document.getElementById('precoCusto').value;
    let precoVenda = document.getElementById('precoVenda').value;
    let quantidadeEstoque = document.getElementById('quantidadeEstoque').value;
    let fornecedorProduto = document.getElementById('fornecedorProduto').value;
    let dataEntrada = document.getElementById('dataEntrada').value;

    // Adiciona os dados na tabela
    let table = document.getElementById('productTable').getElementsByTagName('tbody')[0];
    let newRow = table.insertRow();

    newRow.insertCell(0).innerHTML = nomeProduto;
    newRow.insertCell(1).innerHTML = descricaoProduto;
    newRow.insertCell(2).innerHTML = `R$ ${precoCusto}`;
    newRow.insertCell(3).innerHTML = `R$ ${precoVenda}`;
    newRow.insertCell(4).innerHTML = quantidadeEstoque;
    newRow.insertCell(5).innerHTML = fornecedorProduto;
    newRow.insertCell(6).innerHTML = dataEntrada;

    // Limpa o formulário
    document.getElementById('productForm').reset();
});
        