import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sistema extends JFrame {
    private Loja loja;

    public Sistema() {
        loja = new Loja("Promoções da Localidade");
        setTitle("Menu Principal");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBackground(new Color(0xE0FFEB));

        JButton clienteButton = new JButton("Menu Cliente");
        clienteButton.setBackground(new Color(0x37BC8B)); 
        clienteButton.setForeground(Color.WHITE);
        clienteButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton vendedorButton = new JButton("Menu Vendedor");
        vendedorButton.setBackground(new Color(0x37BC8B)); 
        vendedorButton.setForeground(Color.WHITE);
        vendedorButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton cadastroButton = new JButton("Cadastro de Usuário");
        cadastroButton.setBackground(new Color(0x37BC8B));
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(new Color(0x37BC8B)); 
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 16));

        clienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente clienteFrame = new Cliente(loja);
                clienteFrame.setVisible(true);
            }
        });

        vendedorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Vendedor vendedorFrame = new Vendedor(loja);
                vendedorFrame.setVisible(true);
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroUsuario cadastroFrame = new CadastroUsuario();
                cadastroFrame.setVisible(true);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(clienteButton);
        buttonPanel.add(vendedorButton);
        buttonPanel.add(cadastroButton);
        buttonPanel.add(sairButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Sistema sistemaFrame = new Sistema();
                sistemaFrame.setVisible(true);
            }
        });
    }
}
