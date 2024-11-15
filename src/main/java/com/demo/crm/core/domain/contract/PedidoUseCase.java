package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Pedido;
import com.demo.crm.core.dto.PedidoInput;

import java.util.List;

public interface PedidoUseCase {

        public List<Pedido> listarPedido();
        public PedidoInput listarPedidoPorId (int id);
        public Pedido adicionarPedido (PedidoInput pedido);
        public void deletarPedido (int id);
        public void atualizarPedido (int id, Pedido pedido);

    }
