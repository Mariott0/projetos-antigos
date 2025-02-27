import javax.swing.*;
import java.io.IOException;

public class StudentService {
    private static final String STUDENTS_URL = "https://poo-exam.vercel.app/api/students";

    public void listStudents() {
        try {
            String response = HttpClientHelper.sendGet(STUDENTS_URL);
            JOptionPane.showMessageDialog(null, response, "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            ErrorDialog.showError("Erro ao listar alunos: " + e.getMessage());
        }
    }
}
