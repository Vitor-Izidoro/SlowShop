package dao;

import models.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public VendedorDAO() {
        conexao = Conexao.getConexao();
    }

    // Método para inserir um novo vendedor no banco de dados
    public void inserirVendedor(Vendedor vendedor) {
        this.query = "INSERT INTO vendedor (nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, vendedor.getNome());
            this.ps.setString(2, vendedor.getSobrenome());
            this.ps.setDate(3, Date.valueOf(vendedor.getDataNascimento())); // Conversão de LocalDate para Date
            this.ps.setInt(4, Integer.parseInt(vendedor.getTelefone()));
            this.ps.setInt(5, Integer.parseInt(vendedor.getCpf()));
            this.ps.setString(6, vendedor.getCidade());
            this.ps.setString(7, vendedor.getEstado());
            this.ps.setString(8, vendedor.getPais());
            this.ps.setString(9, vendedor.getEndereco());
            this.ps.setInt(10, vendedor.getNumero());
            this.ps.setDate(11, Date.valueOf(vendedor.getDataCadastro())); // Conversão de LocalDate para Date
            this.ps.setString(12, vendedor.getEmail());
            this.ps.setString(13, vendedor.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean verificarVendedor(String email, String senha) {
        this.query = "SELECT * FROM vendedor WHERE email = ? AND senha = ?";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deletarVendedor(String email) {
        this.query = "DELETE FROM vendedor WHERE email = ?";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, email);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        this.query = "SELECT * FROM vendedor";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getDate("dataNascimento").toLocalDate(),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getDate("dataCadastro").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedores;
    }

    public Vendedor buscarVendedorPorEmail(String email) {
        this.query = "SELECT * FROM vendedor WHERE email = ?";
        Vendedor vendedor = null;

        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vendedor = new Vendedor(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getDate("dataNascimento").toLocalDate(),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getDate("dataCadastro").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedor;
    }
}
