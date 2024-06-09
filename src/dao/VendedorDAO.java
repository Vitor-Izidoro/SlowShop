package dao;

import models.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public VendedorDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirVendedor(Vendedor vendedor) {
        this.query = "INSERT INTO vendedor (nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, vendedor.getNome());
            this.ps.setString(2, vendedor.getSobrenome());
            this.ps.setString(3, vendedor.getDataNascimento());
            this.ps.setString(4, vendedor.getTelefone());
            this.ps.setString(5, vendedor.getCpf());
            this.ps.setString(6, vendedor.getCidade());
            this.ps.setString(7, vendedor.getEstado());
            this.ps.setString(8, vendedor.getPais());
            this.ps.setString(9, vendedor.getEndereco());
            this.ps.setInt(10, vendedor.getNumero());
            this.ps.setString(11, vendedor.getDataCadastro());
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
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, email);
            this.ps.setString(2, senha);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Vendedor> listarVendedores(String email, boolean isAdmin) {
        List<Vendedor> vendedores = new ArrayList<>();
        try {
            if (isAdmin) {
                this.query = "SELECT * FROM vendedor";
                this.ps = conexao.getConnection().prepareStatement(this.query);
            } else {
                this.query = "SELECT * FROM vendedor WHERE email = ?";
                this.ps = conexao.getConnection().prepareStatement(this.query);
                this.ps.setString(1, email);
            }

            ResultSet rs = this.ps.executeQuery();

            while (rs.next()) {
                Vendedor vendedor = new Vendedor(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("dataNascimento"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("dataCadastro"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                vendedores.add(vendedor);
            }
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedores;
    }
}
