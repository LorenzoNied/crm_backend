package com.demo.crm.core.usecase;

import com.demo.crm.core.domain.contract.PedidoRepository;
import com.demo.crm.core.domain.contract.PedidoUseCase;
import com.demo.crm.core.domain.entity.Pedido;
import com.demo.crm.core.dto.PedidoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoUseCaseImpl implements PedidoUseCase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedido() {
        return pedidoRepository.listarPedido();
    }

    @Override
    public PedidoInput listarPedidoPorId(int id) {
        Pedido pedido = pedidoRepository.listarPedidoPorId(id);

        return  new PedidoInput(
                pedido.getId(),
                pedido.getIdCliente(),
                pedido.getStatus(),
                pedido.getValor()
        );
    }

    @Override
    public Pedido adicionarPedido(PedidoInput pedido) {
        return pedidoRepository.adicionarPedido(pedido.toEntity());
    }

    @Override
    public void deletarPedido(int id) {
        pedidoRepository.deletarPedido(id);
    }

    @Override
    public void atualizarPedido(int id, Pedido pedido) {

    }
}
