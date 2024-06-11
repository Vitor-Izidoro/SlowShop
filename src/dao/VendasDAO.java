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

    public void inserirVendas(Vendas venda) {
        this.query = "INSERT INTO vendas (id_cliente, id_vendedor, id_produto, dataPagamento, pagamento, parcelas, total) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(this.query)) {
            ps.setInt(1, venda.getClienteId());
            ps.setInt(2, venda.getVendedorId());
            ps.setInt(3, venda.getVendedorId());
            ps.setString(4, venda.getData());
            ps.setInt(5, venda.getPagamento());
            ps.setDouble(6, venda.getParcelas());
            ps.setDouble(7, venda.getTotal());
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
