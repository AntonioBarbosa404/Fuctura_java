package service;

import model.Cliente;
import model.Veiculo;
import model.Venda;
import model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendaService {
    private List<Venda> vendas = new ArrayList<>();

    public void cadastrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void excluirVenda(Venda venda) {
        vendas.remove(venda);
    }

    public List<Venda> listarVendas() {
        return vendas;
    }

	public void excluirVenda(Veiculo veiculo, Vendedor vendedor, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
}
