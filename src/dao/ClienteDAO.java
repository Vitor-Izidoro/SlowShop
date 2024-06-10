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
        this.query = "INSERT INTO pessoa (nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobrenome());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento())); // Conversão de LocalDate para Date
            ps.setInt(4, Integer.parseInt(cliente.getTelefone()));
            ps.setInt(5, Integer.parseInt(cliente.getCpf()));
            ps.setString(6, cliente.getCidade());
            ps.setString(7, cliente.getEstado());
            ps.setString(8, cliente.getPais());
            ps.setString(9, cliente.getEndereco());
            ps.setInt(10, cliente.getNumero());
            ps.setDate(11, Date.valueOf(cliente.getDataCadastro())); // Conversão de LocalDate para Date
            ps.setString(12, cliente.getEmail());
            ps.setString(13, cliente.getSenha());
            ps.executeUpdate();
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
    public List<Cliente> listarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        this.query = "SELECT * FROM pessoa";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
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
                clientes.add(cliente);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    public boolean verificarCliente(String email, String senha) {
        this.query = "SELECT * FROM pessoa WHERE email = ? AND senha = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Verifica se há resultados
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Cliente não encontrado
        }
    }



    public boolean editarCliente(String email, Cliente cliente) {
        this.query = "UPDATE pessoa SET nome = ?, sobrenome = ?, dataNascimento = ?, telefone = ?, cpf = ?, cidade = ?, estado = ?, pais = ?, endereco = ?, numero = ?, dataCadastro = ?, senha = ? WHERE email = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, cliente.getNome());
            this.ps.setString(2, cliente.getSobrenome());
            this.ps.setDate(3, Date.valueOf(cliente.getDataNascimento())); // Convertendo LocalDate para Date
            this.ps.setString(4, cliente.getTelefone());
            this.ps.setString(5, cliente.getCpf());
            this.ps.setString(6, cliente.getCidade());
            this.ps.setString(7, cliente.getEstado());
            this.ps.setString(8, cliente.getPais());
            this.ps.setString(9, cliente.getEndereco());
            this.ps.setInt(10, cliente.getNumero());
            this.ps.setDate(11, Date.valueOf(cliente.getDataCadastro())); // Convertendo LocalDate para Date
            this.ps.setString(12, cliente.getSenha());
            this.ps.setString(13, email); // Utilize o email como critério de atualização
            int rowsAffected = this.ps.executeUpdate();
            this.ps.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}
