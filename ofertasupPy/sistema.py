from loja import Loja

class Sistema:
    def __init__(self):
        self.usuarios = []
        self.loja = Loja()

    def cadastrar_usuario(self, nome, email, senha):
        usuario = {"nome": nome, "email": email, "senha": senha}
        self.usuarios.append(usuario)
        print("Usuário cadastrado com sucesso!")
