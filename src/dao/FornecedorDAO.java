package dao;

import models.Fornecedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    private Conexao conexao;

    public FornecedorDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirFornecedor(Fornecedor fornecedor) {
        String query = "INSERT INTO fornecedor (nomeFantasia, razaoSocial, cnpj, email, telefone, cidade, estado, pais, endereco, numero, dataCadastro, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, fornecedor.getNomeFantasia());
            ps.setString(2, fornecedor.getRazaoSocial());
            ps.setString(3, fornecedor.getCnpj());
            ps.setString(4, fornecedor.getEmail());
            ps.setString(5, fornecedor.getTelefone());
            ps.setString(6, fornecedor.getCidade());
            ps.setString(7, fornecedor.getEstado());
            ps.setString(8, fornecedor.getPais());
            ps.setString(9, fornecedor.getEndereco());
            ps.setString(10, fornecedor.getNumero());

            if (fornecedor.getDataCadastro() != null) {
                ps.setDate(11, Date.valueOf(fornecedor.getDataCadastro()));
            } else {
                ps.setDate(11, Date.valueOf(java.time.LocalDate.now()));
            }

            ps.setString(12, fornecedor.getSenha());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Melhor substituir por um log apropriado
        }
    }

    public boolean deletarFornecedor(String email) {
        String query = "DELETE FROM fornecedor WHERE email = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // Melhor substituir por um log apropriado
            return false;
        }
    }

    public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String query = "SELECT * FROM fornecedor ORDER BY dataCadastro";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor(
                        rs.getString("nomeFantasia"),
                        rs.getString("razaoSocial"),
                        rs.getString("cnpj"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getDate("dataCadastro").toLocalDate(),
                        rs.getString("senha")
                );
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Melhor substituir por um log apropriado
        }
        return fornecedores;
    }
}
