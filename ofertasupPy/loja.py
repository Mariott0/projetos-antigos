from produto import Produto

class Loja:
    def __init__(self):
        self.produtos = []

    def adicionar_produto(self, produto: Produto):
        self.produtos.append(produto)
        print(f"Produto {produto.nome} adicionado com sucesso!")
