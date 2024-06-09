package dao;

import models.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public AdminDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirAdmin(Admin admin) {
        this.query = "INSERT INTO admin (nome, email, senha) VALUES (?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, admin.getNome());
            this.ps.setString(2, admin.getEmail());
            this.ps.setString(3, admin.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean verificarAdmin(String email, String senha) {
        this.query = "SELECT * FROM admin WHERE email = ? AND senha = ?";
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
}
