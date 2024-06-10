package models;

public class Vendas {
    private int id;
    private int clienteId;
    private int vendedorId;
    private String data;
    private int pagamento;
    private double parcelas;
    private double total;

    public Vendas(int id, int clienteId, int vendedorId, String data, int pagamento, double parcelas, double total) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
