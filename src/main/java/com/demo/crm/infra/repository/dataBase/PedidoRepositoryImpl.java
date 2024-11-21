package com.demo.crm.infra.repository.dataBase;

import com.demo.crm.core.domain.contract.PedidoRepository;
import com.demo.crm.core.domain.entity.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Pedido> listarPedido() {
        var query = """
                SELECT * FROM pedido;
                """;
        return entityManager.createNativeQuery(query, Pedido.class).getResultList();
    }

    @Override
    public Pedido listarPedidoPorId(int id) {
        var query = """
                SELECT * FROM pedido WHERE id = :id;
                """;
        return (Pedido) entityManager.createNativeQuery(query, Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Pedido adicionarPedido(Pedido pedido) {
        var query = """
                INSERT INTO pedido (id_cliente, status, valor)
                VALUES (:idClient, :status, :valor)
                RETURNING id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("idClient", pedido.getIdCliente())
                .setParameter("status", pedido.getStatus())
                .setParameter("valor", pedido.getValor())
                .getSingleResult();
        return pedido;
    }

    @Transactional
    @Override
    public void deletarPedido(int id) {
        var query = """
                DELETE FROM pedido WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Pedido.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void atualizarPedido(int id, Pedido pedido) {

    }

}
