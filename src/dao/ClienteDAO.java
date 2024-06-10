package dao;

import models.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public ClienteDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirCliente(Cliente cliente) {
        this.query = "INSERT INTO pessoa (nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, email, senha, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, cliente.getNome());
            this.ps.setString(2, cliente.getSobrenome());
            this.ps.setString(3, cliente.getDataNascimento());
            this.ps.setString(4, cliente.getTelefone());
            this.ps.setString(5, cliente.getCpf());
            this.ps.setString(6, cliente.getCidade());
            this.ps.setString(7, cliente.getEstado());
            this.ps.setString(8, cliente.getPais());
            this.ps.setString(9, cliente.getEndereco());
            this.ps.setString(10, cliente.getNumero());
            this.ps.setString(11, cliente.getEmail());
            this.ps.setString(12, cliente.getSenha());
            this.ps.setString(13, cliente.getDataCadastro());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean deletarCliente(String email) {
        this.query = "DELETE FROM pessoa WHERE email = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, email);
            int rowsAffected = this.ps.executeUpdate();
            this.ps.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean verificarCliente(String email, String senha) {
        this.query = "SELECT * FROM pessoa WHERE email = ? AND senha = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, email);
            this.ps.setString(2, senha);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                return true; // Cliente encontrado
            }
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false; // Cliente não encontrado
    }
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM pessoa";
            Statement stmt = conexao.getConnection().prepareStatement(this.query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getString("numero"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("data_cadastro")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
}
