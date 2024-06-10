package dao;

import models.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public ProdutoDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirProduto(Produto produto) {
        this.query = "INSERT INTO produto (descricao, quantidade, preco, id_fornecedor) VALUES (?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, produto.getDescricao());
            this.ps.setInt(2, produto.getQuantidade());
            this.ps.setDouble(3, produto.getPreco());
            this.ps.setInt(4, produto.getFornecedorId());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
/*
import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static List<Produto> produtos = new ArrayList<>();

    public void inserirProduto(Produto produto) {
        produto.setId(produtos.size() + 1);
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }
}

 */
