package dao;

import models.Cliente;
import models.Fornecedor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public FornecedorDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirFornecedor(Fornecedor fornecedor) {
        this.query = "INSERT INTO fornecedor (nomeFantasia, razaoSocial, cnpj, email, telefone, cidade, estado, pais, endereco, numero, dataCadastro, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, fornecedor.getNomeFantasia());
            this.ps.setString(2, fornecedor.getRazaoSocial());
            this.ps.setString(3, fornecedor.getCnpj());
            this.ps.setString(4, fornecedor.getEmail());
            this.ps.setString(5, fornecedor.getTelefone());
            this.ps.setString(6, fornecedor.getCidade());
            this.ps.setString(7, fornecedor.getEstado());
            this.ps.setString(8, fornecedor.getPais());
            this.ps.setString(9, fornecedor.getEndereco());
            this.ps.setString(10, fornecedor.getNumero());
            this.ps.setDate(11, Date.valueOf(fornecedor.getDataCadastro()));
            this.ps.setString(12, fornecedor.getSenha()); // Novo campo
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean deletarFornecedor(String email) {
        this.query = "DELETE FROM fornecedor WHERE email = ?";
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

    public List<Fornecedor> listarFornecedor() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        this.query = "SELECT * FROM fornecedor";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                Fornecedor fornedor = new Fornecedor(
                        rs.getString("nomeFantasia"),
                        rs.getString("razaoSocial"),
                        rs.getString("cnpj"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("pais"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getDate("dataCadastro").toLocalDate(),
                        rs.getString("senha")
                );
                fornecedores.add(fornedor);
            }
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fornecedores;
    }
}
/*import models.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    private static List<Fornecedor> fornecedores = new ArrayList<>();

    public void inserirFornecedor(Fornecedor fornecedor) {
        fornecedor.setId(fornecedores.size() + 1);
        fornecedores.add(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    public Fornecedor buscarFornecedorPorEmail(String email) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getEmail().equals(email)) {
                return fornecedor;
            }
        }
        return null;
    }
}*/

