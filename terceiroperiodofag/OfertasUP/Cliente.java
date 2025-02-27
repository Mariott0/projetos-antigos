import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Cliente extends JFrame {
    private Loja loja;

    public Cliente(Loja loja) {
        this.loja = loja;
        setTitle("Menu Cliente");
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
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(new Color(0xE0FFEB));

        JButton buscarNomeButton = new JButton("Buscar produto por nome");
        buscarNomeButton.setBackground(new Color(0x37BC8B)); 
        buscarNomeButton.setForeground(Color.WHITE);
        buscarNomeButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton buscarCategoriaButton = new JButton("Buscar produto por categoria");
        buscarCategoriaButton.setBackground(new Color(0x37BC8B)); 
        buscarCategoriaButton.setForeground(Color.WHITE);
        buscarCategoriaButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(new Color(0x37BC8B)); 
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 16));

        buscarNomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorNome();
            }
        });

        buscarCategoriaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorCategoria();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(buscarNomeButton);
        buttonPanel.add(buscarCategoriaButton);
        buttonPanel.add(sairButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private void buscarPorNome() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        List<Produto> produtos = loja.buscarPorNome(nome);
        mostrarResultados(produtos);
    }

    private void buscarPorCategoria() {
        String categoria = JOptionPane.showInputDialog(this, "Digite a categoria do produto:");
        List<Produto> produtos = loja.buscarPorCategoria(categoria);
        mostrarResultados(produtos);
    }

    private void mostrarResultados(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.");
        } else {
            String[] opcoes = new String[produtos.size()];
            for (int i = 0; i < produtos.size(); i++) {
                opcoes[i] = produtos.get(i).getNome();
            }
            String escolha = (String) JOptionPane.showInputDialog(this, "Selecione um produto", "Resultados", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha != null) {
                for (Produto produto : produtos) {
                    if (produto.getNome().equals(escolha)) {
                        ProdutoDetalhado detalhes = new ProdutoDetalhado(produto);
                        detalhes.setVisible(true);
                        break;
                    }
                }
            }
        }
    }
}
