package dao;

import models.Vendas;
import java.sql.*;

public class VendasDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public VendasDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirVenda(Vendas venda) {
        this.query = "INSERT INTO vendas (cliente_id, vendedor_id, data, pagamento, parcelas, total) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setInt(1, venda.getClienteId());
            ps.setInt(2, venda.getVendedorId()); // Certifique-se de que o vendedorId esteja sendo passado corretamente aqui
            ps.setString(3, venda.getData());
            ps.setInt(4, venda.getPagamento());
            ps.setDouble(5, venda.getParcelas());
            ps.setDouble(6, venda.getTotal());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletarVenda(int id) {
        this.query = "DELETE FROM vendas WHERE id = ?";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
