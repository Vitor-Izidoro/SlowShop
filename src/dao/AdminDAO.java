package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Admin;

public class AdminDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public AdminDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirAdmin(Admin admin) {
        this.query = "INSERT INTO admin (nome, senha, email) VALUES (?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, admin.getNome());
            this.ps.setString(2, admin.getSenha());
            this.ps.setString(3, admin.getEmail());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
