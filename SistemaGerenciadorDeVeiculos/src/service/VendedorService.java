package service;

import model.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class VendedorService {
    private List<Vendedor> vendedores = new ArrayList<>();

    public void cadastrarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public Vendedor consultarVendedorPorNome(String nome) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nome)) {
                return vendedor;
            }
        }
        return null;
    }

    public void excluirVendedor(String nome) {
        vendedores.removeIf(vendedor -> vendedor.getNome().equals(nome));
    }

    public void alterarVendedor(String nome, Vendedor novoVendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getNome().equals(nome)) {
                vendedores.set(i, novoVendedor);
                break;
            }
        }
    }
}
