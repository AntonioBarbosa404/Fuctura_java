package service;

import model.Loja;
import java.util.ArrayList;
import java.util.List;

public class LojaService {
    private List<Loja> lojas = new ArrayList<>();

    public void cadastrarLoja(Loja loja) {
        lojas.add(loja);
    }

    public List<Loja> listarLojas() {
        return lojas;
    }

    public void excluirLoja(String nome) {
        lojas.removeIf(loja -> loja.getNome().equals(nome));
    }

    public void alterarLoja(String nome, Loja novaLoja) {
        for (int i = 0; i < lojas.size(); i++) {
            if (lojas.get(i).getNome().equals(nome)) {
                lojas.set(i, novaLoja);
                break;
            }
        }
    }
}
