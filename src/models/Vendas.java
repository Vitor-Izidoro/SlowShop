package models;

import java.sql.*;

public class Vendas {
    private int id;
    private int clienteId;
    private int vendedorId;
    private double data;
    private int pagamento;
    private double parcelas;
    private int total;

    public Vendas(int id, int clienteId, int vendedorId, double data, int pagamento, double parcelas, int total) {
        this.id = id;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.data = data;
        this.pagamento = pagamento;
        this.parcelas = parcelas;
        this.total = total;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public double getParcelas() {
        return parcelas;
    }

    public void setParcelas(double parcelas) {
        this.parcelas = parcelas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
