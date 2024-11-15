package com.demo.crm.core.domain.contract;


import com.demo.crm.core.domain.entity.Pedido;
import com.demo.crm.core.dto.PedidoInput;

import java.util.List;

public interface PedidoRepository {

        public List<Pedido> listarPedido();
        public Pedido listarPedidoPorId (int id);
        public int adicionarPedido (Pedido pedido);
        public void deletarPedido (int id);
        public void atualizarPedido (int id, Pedido pedido);

    }

