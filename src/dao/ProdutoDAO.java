package dao;

import models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Produto buscarProdutoPorId(int id) {
        this.query = "SELECT * FROM produto WHERE id_produto = ?";
        Connection conn = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            conn = conexao.getConnection();
            this.ps = conn.prepareStatement(this.query);
            this.ps.setInt(1, id);
            rs = this.ps.executeQuery();

            if (rs.next()) {
                produto = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("descricao"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getInt("id_fornecedor")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (this.ps != null) this.ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return produto;
    }

    public boolean verificarProduto(int id, String senha) {
        this.query = "SELECT * FROM pessoa WHERE email = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, String.valueOf(id));
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean atualizarProduto(int id, Produto produto) {
        this.query = "UPDATE produto SET descricao = ?, quantidade = ?, preco = ?, id_fornecedor = ? WHERE id_produto = ?";
        Connection conn = null;
        int rowsAffected = 0;

        try {
            conn = conexao.getConnection();
            this.ps = conn.prepareStatement(this.query);
            this.ps.setString(1, produto.getDescricao());
            this.ps.setInt(2, produto.getQuantidade());
            this.ps.setDouble(3, produto.getPreco());
            this.ps.setInt(4, produto.getFornecedorId());
            this.ps.setInt(5, produto.getId_produto());
            rowsAffected = this.ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (this.ps != null) this.ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rowsAffected > 0;
    }

    public boolean atualizarQuantidadeProduto(int id_produto, int novaQuantidade) {
        this.query = "UPDATE produto SET quantidade = ? WHERE id_produto = ?";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setInt(1, novaQuantidade);
            ps.setInt(2, id_produto);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        this.query = "SELECT * FROM produto";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("descricao"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getInt("id_fornecedor")
                );
                produtos.add(produto);
            }
            rs.close();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produtos;
    }
}
