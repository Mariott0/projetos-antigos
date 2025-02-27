import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Aluno> alunos;

    public Biblioteca() {
        livros = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Livro buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isEmprestado()) {
                return livro;
            }
        }
        return null;
    }

    public Livro buscarPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor) && !livro.isEmprestado()) {
                return livro;
            }
        }
        return null;
    }

    public void emprestarLivro(Livro livro, Aluno aluno) {
        if (!livro.isEmprestado()) {
            livro.emprestar();
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro já está emprestado.");
        }
    }

    public void devolverLivro(Livro livro) {
        livro.devolver();
    }

    public boolean verificarDisponibilidade(String titulo) {
        Livro livro = buscarPorTitulo(titulo);
        return livro != null && !livro.isEmprestado();
    }

    public double calcularMulta(int diasAtrasados) {
        if (diasAtrasados > 7) {
            return (diasAtrasados - 7) * 3.50;
        }
        return 0;
    }
}
