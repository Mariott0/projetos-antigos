import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vendedor extends JFrame {
    private Loja loja;

    public Vendedor(Loja loja) {
        this.loja = loja;
        setTitle("Menu Vendedor");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(0xE0FFEB));

 
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0xE0FFEB));

      
        ImageIcon logo = new ImageIcon(new ImageIcon("D:\\.Code\\OfertasUP\\img\\LOGO.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        topPanel.add(logoLabel, BorderLayout.WEST);

      
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBackground(new Color(0xE0FFEB));

        JButton cadastrarProdutoButton = new JButton("Cadastrar produto");
        cadastrarProdutoButton.setBackground(new Color(0x37BC8B)); // Verde médio
        cadastrarProdutoButton.setForeground(Color.WHITE);
        cadastrarProdutoButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(new Color(0x37BC8B)); 
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 16));

        cadastrarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(cadastrarProdutoButton);
        buttonPanel.add(sairButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private void cadastrarProduto() {
        JTextField nomeField = new JTextField();
        JTextField categoriaField = new JTextField();
        JTextField precoField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField fotoField = new JTextField();
        JTextField enderecoField = new JTextField();

        Object[] fields = {
            "Nome:", nomeField,
            "Categoria:", categoriaField,
            "Preço:", precoField,
            "Descrição:", descricaoField,
            "URL da Foto:", fotoField,
            "Endereço:", enderecoField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String categoria = categoriaField.getText();
            double preco;
            try {
                preco = Double.parseDouble(precoField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Preço inválido.");
                return;
            }
            String descricao = descricaoField.getText();
            String foto = fotoField.getText();
            String endereco = enderecoField.getText();

            Produto produto = new Produto(nome, categoria, preco, descricao, foto, endereco);
            loja.adicionarProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        }
    }
}
