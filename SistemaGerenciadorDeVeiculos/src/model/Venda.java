package model;

import java.util.Date;

public class Venda {
    private Veiculo veiculo;
    private Vendedor vendedor;
    private Cliente cliente;
    private Date dataVenda;

    public Venda() {
    }

    public Venda(Veiculo veiculo, Vendedor vendedor, Cliente cliente, Date dataVenda) {
        this.veiculo = veiculo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
