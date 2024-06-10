package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Vendas;

public class VendasDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public VendasDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirVenda(Vendas venda) {
        this.query = "INSERT INTO vendas (cliente_id, vendedor_id, data, pagamento, parcelas, total) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, venda.getClienteId());
            this.ps.setInt(2, venda.getVendedorId());
            this.ps.setDouble(3, venda.getData());
            this.ps.setInt(4, venda.getPagamento());
            this.ps.setDouble(5, venda.getParcelas());
            this.ps.setInt(6, venda.getTotal());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletarVenda(int id) {
        this.query = "DELETE FROM vendas WHERE id = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, id);
            int rowsAffected = this.ps.executeUpdate();
            this.ps.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
