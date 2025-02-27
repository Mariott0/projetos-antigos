import javax.swing.*;
import java.io.IOException;

public class TestimonialService {
    private static final String TESTIMONIAL_URL = "https://poo-exam.vercel.app/api/testimonial";
    private static final String PHOTO_URL = "https://avatars.githubusercontent.com/u/115180122?v=4";

    public void createTestimonial() {
        try {
            String studentRA = JOptionPane.showInputDialog("Informe o RA do aluno:");
            String text = JOptionPane.showInputDialog("Informe o texto do testemunho:");

            String payload = String.format("{\"imageUrl\":\"%s\", \"ra\":\"%s\", \"description\":\"%s\"}", PHOTO_URL, studentRA, text);
            String response = HttpClientHelper.sendPost(TESTIMONIAL_URL, payload);
            JOptionPane.showMessageDialog(null, response, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            ErrorDialog.showError("Erro ao criar testemunho: " + e.getMessage());
        }
    }
}
