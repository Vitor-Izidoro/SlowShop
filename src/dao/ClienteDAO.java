package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public ClienteDAO(){
        conexao = Conexao.getConexao();
    }

    public void inserirCliente(){

        this.query = "INSERT INTO cliente (nome,senha) VALUES (?,?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, "vitor03");
            this.ps.setString(2, "aaaaa");
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
