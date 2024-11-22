package com.demo.crm.core.dto;

import com.demo.crm.core.domain.entity.Pedido;

public record PedidoInput(
        int id,
        int idCliente,
        String status,
        int valor
) {
    public Pedido toEntity(){
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setIdCliente(idCliente);
        pedido.setStatus(status);
        pedido.setValor(valor);
        return pedido;
    }
}
