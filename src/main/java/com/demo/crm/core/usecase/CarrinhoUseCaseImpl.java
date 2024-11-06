package com.demo.crm.core.usecase;

import com.demo.crm.core.domain.contract.CarrinhoUseCase;
import com.demo.crm.core.domain.entity.Carrinho;

import java.util.List;

public class CarrinhoUseCaseImpl implements CarrinhoUseCase {
    @Override
    public List<Carrinho> listar() {
        return List.of();
    }

    @Override
    public Carrinho listarCarrinhoPorId(int id) {
        return null;
    }

    @Override
    public void adicionarCarrinho(Carrinho carrinho) {

    }

    @Override
    public String deletarCarrinho(int id) {
        return "";
    }

    @Override
    public String atualizarCarrinho(int id, Carrinho carrinho) {
        return "";
    }
}
