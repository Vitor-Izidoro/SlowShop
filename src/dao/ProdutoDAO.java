package dao;

import models.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public boolean deletarProduto(String descricao) {
        this.query = "DELETE FROM produto WHERE descricao = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, descricao);
            int rowsAffected = this.ps.executeUpdate();
            this.ps.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

//    public Produto buscarProdutoPorId(int id) {
//        this.query = "SELECT * FROM produto WHERE id_produto = ?";
//        try {
//            this.ps = conexao.getConnection().prepareStatement(this.query);
//            this.ps.setInt(1, id);
//            ResultSet rs = this.ps.executeQuery();
//            if (rs.next()) {
//                Produto produto = new Produto(
//                        rs.getInt("id_produto"),
//                        rs.getString("descricao"),
//                        rs.getInt("quantidade"),
//                        rs.getDouble("preco"),
//                        rs.getInt("id_fornecedor")
//                );
//                this.ps.close();
//                return produto;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
    }

//    public boolean atualizarProduto(Produto produto) {
//        this.query = "UPDATE produto SET descricao = ?, quantidade = ?, preco = ?, id_fornecedor = ? WHERE id_produto = ?";
//        try {
//            this.ps = conexao.getConnection().prepareStatement(this.query);
//            this.ps.setString(1, produto.getDescricao());
//            this.ps.setInt(2, produto.getQuantidade());
//            this.ps.setDouble(3, produto.getPreco());
//            this.ps.setInt(4, produto.getIdFornecedor());
//            this.ps.setInt(5, produto.getId());
//            int rowsAffected = this.ps.executeUpdate();
//            this.ps.close();
//            return rowsAffected > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
  //  }
//}
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
