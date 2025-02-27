import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\nBiblioteca Central - Menu Principal");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Buscar Livro por Título");
            System.out.println("4. Buscar Livro por Autor");
            System.out.println("5. Realizar Empréstimo");
            System.out.println("6. Realizar Devolução");
            System.out.println("7. Verificar Disponibilidade de um Livro");
            System.out.println("8. Calcular Multa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.cadastrarLivro(new Livro(titulo, autor));
                    break;
                case 2:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Digite o ID do aluno: ");
                    int idAluno = scanner.nextInt();
                    scanner.nextLine(); 
                    biblioteca.cadastrarAluno(new Aluno(nomeAluno, idAluno));
                    break;
                case 3:
                    System.out.print("Digite o título do livro para busca: ");
                    String buscaTitulo = scanner.nextLine();
                    Livro livroTitulo = biblioteca.buscarPorTitulo(buscaTitulo);
                    if (livroTitulo != null)
                        System.out.println("Livro encontrado: " + livroTitulo.getTitulo());
                    else
                        System.out.println("Livro não encontrado ou já emprestado.");
                    break;
                case 4:
                    System.out.print("Digite o autor do livro para busca: ");
                    String buscaAutor = scanner.nextLine();
                    Livro livroAutor = biblioteca.buscarPorAutor(buscaAutor);
                    if (livroAutor != null)
                        System.out.println("Livro encontrado: " + livroAutor.getAutor());
                    else
                        System.out.println("Livro não encontrado ou já emprestado.");
                    break;
                case 5:
                    System.out.print("Digite o título do livro a ser emprestado: ");
                    String emprestimoTitulo = scanner.nextLine();
                    Livro livroEmprestimo = biblioteca.buscarPorTitulo(emprestimoTitulo);
                    if (livroEmprestimo != null && !livroEmprestimo.isEmprestado()) {
                        System.out.print("Digite o ID do aluno que está tomando emprestado: ");
                        int alunoIdEmprestimo = scanner.nextInt();
                        scanner.nextLine();

                        biblioteca.emprestarLivro(livroEmprestimo, new Aluno("", alunoIdEmprestimo));
                    } else {
                        System.out.println("Livro não disponível para empréstimo.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    String devolucaoTitulo = scanner.nextLine();
                    Livro livroDevolucao = biblioteca.buscarPorTitulo(devolucaoTitulo);
                    if (livroDevolucao != null) {
                        biblioteca.devolverLivro(livroDevolucao);
                    } else {
                        System.out.println("Livro não encontrado no sistema.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o título do livro para verificar disponibilidade: ");
                    String disponibilidadeTitulo = scanner.nextLine();
                    boolean disponivel = biblioteca.verificarDisponibilidade(disponibilidadeTitulo);
                    if (disponivel)
                        System.out.println("Livro disponível para empréstimo.");
                    else
                        System.out.println("Livro não está disponível.");
                    break;
                case 8:
                    System.out.print("Digite o número de dias de atraso: ");
                    
                    int diasAtraso = scanner.nextInt();
                    double multa = biblioteca.calcularMulta(diasAtraso);
                    System.out.printf("Valor da multa: R$ %.2f\n", multa);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
