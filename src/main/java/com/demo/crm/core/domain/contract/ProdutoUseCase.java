package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoUseCase {
    public List<Produto> listarProduto();
    public Produto listarProdutoPorId (int id);
    public void adicionarProduto (Produto produto);
    public String deletarProduto (int id);
    public String atualizarProduto (int id, Produto produto);

}
