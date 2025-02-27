import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuario extends JFrame {
    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
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


        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridLayout(7, 2, 10, 10));
        cadastroPanel.setBackground(new Color(0xE0FFEB));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();
        JLabel confirmarSenhaLabel = new JLabel("Confirmar Senha:");
        JPasswordField confirmarSenhaField = new JPasswordField();
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(new Color(0x37BC8B));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(new Color(0x37BC8B));
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 16));

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                String senha = new String(senhaField.getPassword());
                String confirmarSenha = new String(confirmarSenhaField.getPassword());
                if (!senha.equals(confirmarSenha)) {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cadastroPanel.add(nomeLabel);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(emailLabel);
        cadastroPanel.add(emailField);
        cadastroPanel.add(senhaLabel);
        cadastroPanel.add(senhaField);
        cadastroPanel.add(confirmarSenhaLabel);
        cadastroPanel.add(confirmarSenhaField);
        cadastroPanel.add(cadastrarButton);
        cadastroPanel.add(sairButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(cadastroPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }
}
