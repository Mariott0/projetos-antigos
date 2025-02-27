import tkinter as tk
from tkinter import messagebox
from cadastro_usuario import CadastroUsuario
from sistema import Sistema
from produto import Produto

class Aplicativo:
    def __init__(self):
        self.sistema = Sistema()
        self.root = tk.Tk()
        self.root.title("Sistema de Gestão")
        self.root.geometry("400x400")

        self.create_main_menu()

        self.root.mainloop()

    def create_main_menu(self):
        # Criação dos botões principais
        tk.Button(self.root, text="Cadastrar Usuário", command=self.cadastrar_usuario).pack(pady=10)
        tk.Button(self.root, text="Cadastrar Produto", command=self.cadastrar_produto).pack(pady=10)
        tk.Button(self.root, text="Visualizar Produtos", command=self.visualizar_produtos).pack(pady=10)
        tk.Button(self.root, text="Sair", command=self.root.quit).pack(pady=10)

    def cadastrar_usuario(self):
        CadastroUsuario()

    def cadastrar_produto(self):
        window = tk.Toplevel(self.root)
        window.title("Cadastrar Produto")
        window.geometry("300x300")

        tk.Label(window, text="Nome:").pack()
        nome_entry = tk.Entry(window)
        nome_entry.pack()

        tk.Label(window, text="Categoria:").pack()
        categoria_entry = tk.Entry(window)
        categoria_entry.pack()

        tk.Label(window, text="Preço:").pack()
        preco_entry = tk.Entry(window)
        preco_entry.pack()

        tk.Label(window, text="Descrição:").pack()
        descricao_entry = tk.Entry(window)
        descricao_entry.pack()

        tk.Label(window, text="URL da Foto:").pack()
        foto_entry = tk.Entry(window)
        foto_entry.pack()

        tk.Label(window, text="Endereço:").pack()
        endereco_entry = tk.Entry(window)
        endereco_entry.pack()

        def adicionar_produto():
            nome = nome_entry.get()
            categoria = categoria_entry.get()
            try:
                preco = float(preco_entry.get())
            except ValueError:
                messagebox.showerror("Erro", "Preço inválido")
                return
            descricao = descricao_entry.get()
            foto = foto_entry.get()
            endereco = endereco_entry.get()

            novo_produto = Produto(nome, categoria, preco, descricao, foto, endereco)
            self.sistema.loja.adicionar_produto(novo_produto)
            messagebox.showinfo("Sucesso", "Produto cadastrado com sucesso!")
            window.destroy()

        tk.Button(window, text="Adicionar Produto", command=adicionar_produto).pack(pady=10)

    def visualizar_produtos(self):
        produtos = self.sistema.loja.produtos
        if not produtos:
            messagebox.showinfo("Informação", "Nenhum produto cadastrado.")
            return

        window = tk.Toplevel(self.root)
        window.title("Produtos Cadastrados")
        window.geometry("400x400")

        for produto in produtos:
            tk.Label(window, text=f"Nome: {produto.nome}").pack()
            tk.Label(window, text=f"Categoria: {produto.categoria}").pack()
            tk.Label(window, text=f"Preço: {produto.preco}").pack()
            tk.Label(window, text=f"Descrição: {produto.descricao}").pack()
            tk.Label(window, text="-" * 40).pack()
