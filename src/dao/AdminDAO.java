package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Admin;

public class AdminDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public AdminDAO() {
        conexao = new Conexao();
    }

    public void inserirAdmin(Admin admin) {
        try {
            query = "INSERT INTO admin (nome, email, senha) VALUES (?, ?, ?)";
            ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir admin: " + e.getMessage());
        }
    }

    public boolean verificarAdmin(String email, String senha) {
        try {
            query = "SELECT * FROM admin WHERE email = ? AND senha = ?";
            ps = conexao.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar admin: " + e.getMessage());
            return false;
        }
    }
}
