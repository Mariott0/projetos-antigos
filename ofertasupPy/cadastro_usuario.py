import tkinter as tk
from tkinter import messagebox

class CadastroUsuario:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Cadastro de Usuário")
        self.window.geometry("300x300")
        
        # Labels e Entradas
        tk.Label(self.window, text="Nome:").pack()
        self.nome_entry = tk.Entry(self.window)
        self.nome_entry.pack()
        
        tk.Label(self.window, text="Email:").pack()
        self.email_entry = tk.Entry(self.window)
        self.email_entry.pack()
        
        tk.Label(self.window, text="Senha:").pack()
        self.senha_entry = tk.Entry(self.window, show="*")
        self.senha_entry.pack()
        
        tk.Label(self.window, text="Confirmar Senha:").pack()
        self.confirmar_senha_entry = tk.Entry(self.window, show="*")
        self.confirmar_senha_entry.pack()
        
        # Botões
        cadastrar_button = tk.Button(self.window, text="Cadastrar", command=self.cadastrar)
        cadastrar_button.pack(pady=10)
        
        sair_button = tk.Button(self.window, text="Sair", command=self.window.quit)
        sair_button.pack(pady=10)
        
        self.window.mainloop()

    def cadastrar(self):
        nome = self.nome_entry.get()
        email = self.email_entry.get()
        senha = self.senha_entry.get()
        confirmar_senha = self.confirmar_senha_entry.get()
        
        if senha != confirmar_senha:
            messagebox.showerror("Erro", "As senhas não coincidem.")
        else:
            messagebox.showinfo("Sucesso", "Usuário cadastrado com sucesso!")
