import javax.swing.*;
import java.awt.*;

public class ProdutoDetalhado extends JFrame {
    public ProdutoDetalhado(Produto produto) {
        setTitle("Detalhes do Produto");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(0xE0FFEB)); // Verde claro

        JLabel nomeLabel = new JLabel("Nome: " + produto.getNome());
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel categoriaLabel = new JLabel("Categoria: " + produto.getCategoria());
        categoriaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel precoLabel = new JLabel("Preço: " + produto.getPreco());
        precoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel descricaoLabel = new JLabel("<html><body style='width: 800px'>" + produto.getDescricao() + "</body></html>");
        descricaoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel enderecoLabel = new JLabel("Endereço: " + produto.getEndereco());
        enderecoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel fotoLabel = new JLabel();
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(produto.getFoto()).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        fotoLabel.setIcon(imageIcon);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(0xE0FFEB));
        infoPanel.add(nomeLabel);
        infoPanel.add(categoriaLabel);
        infoPanel.add(precoLabel);
        infoPanel.add(descricaoLabel);
        infoPanel.add(enderecoLabel);

        panel.add(infoPanel, BorderLayout.NORTH);
        panel.add(fotoLabel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }
}
