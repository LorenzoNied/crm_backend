package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Carrinho;

import java.util.List;

public interface CarrinhoUseCase {
        public List<Carrinho> listar();
        public Carrinho listarCarrinhoPorId (int id);
        public void adicionarCarrinho (Carrinho carrinho);
        public String deletarCarrinho (int id);
        public String atualizarCarrinho (int id, Carrinho carrinho);

}
