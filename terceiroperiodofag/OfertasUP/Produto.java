public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private String descricao;
    private String foto;
    private String endereco;

    public Produto(String nome, String categoria, double preco, String descricao, String foto, String endereco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.foto = foto;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFoto() {
        return foto;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + "]";
    }
}
