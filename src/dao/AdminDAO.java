package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public AdminDAO(){
        conexao = Conexao.getConexao();
    }

    public void inserirAdmin() {
        this.query = "INSERT INTO admin (nome, senha, email) VALUES (?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, "vitor03");
            this.ps.setString(2, "aaaaa");
            this.ps.setString(3, "vitor03@example.com");  // Adicione o email aqui
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
