package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Pedido;

import java.util.List;

public interface PedidoUseCase {
    public List<Pedido> listarPedido();
    public Pedido listarPedidoPorId (int id);
    public void adicionarPedido (Pedido pedido);
    public String deletarPedido (int id);
    public String atualizarPedido (int id, Pedido pedido);

}
