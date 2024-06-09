package models;

public class Produto {
    private String descricao;
    private int quantidade;
    private double preco;
    private int fornecedorId;

    public Produto(String descricao, int quantidade, double preco, int fornecedorId) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.fornecedorId = fornecedorId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
}
