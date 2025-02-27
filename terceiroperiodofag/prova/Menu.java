import javax.swing.*;

public class Menu {
    private final StudentService studentService;
    private final TestimonialService testimonialService;

    public Menu() {
        studentService = new StudentService();
        testimonialService = new TestimonialService();
    }

    public void display() {
        while (true) {
            String[] options = {"Listar Alunos", "Criar Testemunho", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    studentService.listStudents();
                    break;
                case 1:
                    testimonialService.createTestimonial();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
