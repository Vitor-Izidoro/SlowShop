package dao;

import models.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            this.ps.setString(11, fornecedor.getDataCadastro());
            this.ps.setString(12, fornecedor.getSenha()); // Novo campo
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
