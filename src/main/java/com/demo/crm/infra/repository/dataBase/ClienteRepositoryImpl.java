package com.demo.crm.infra.repository.dataBase;

import com.demo.crm.core.domain.contract.ClienteRepository;
import com.demo.crm.core.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Cliente> listarCliente() {
        var query = """
                SELECT * FROM cliente;
                """;
        return entityManager.createNativeQuery(query, Cliente.class).getResultList();
    }

    @Override
    public Cliente listarClientePorId(int id) {
        var query = """
                SELECT * FROM cliente WHERE id = :id;
                """;
        return (Cliente) entityManager.createNativeQuery(query, Cliente.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    @Override
    public int adicionarCliente(Cliente cliente) throws Exception {
        var query = """
                INSERT INTO cliente (nome, cpf, telefone)
                VALUES (:nome, :cpf, :telefone)
                RETURNING id;
                """;
        return (int) entityManager.createNativeQuery(query)
                .setParameter("nome", cliente.getNome())
                .setParameter("cpf", cliente.getCpf())
                .setParameter("telefone", cliente.getTelefone())
                .getSingleResult();
    }

    @Transactional
    @Override
    public void deletarCliente(int id) throws  Exception {
        var query = """
                DELETE FROM cliente WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Cliente.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarCliente(int id, Cliente cliente) throws Exception {
        var query = """
                UPDATE cliente SET 
                nome = :nome,
                telefone = :telefone,
                cpf = :cpf
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Cliente.class)
                .setParameter("nome", cliente.getNome())
                .setParameter("telefone", cliente.getTelefone())
                .setParameter("cpf", cliente.getCpf())
                .setParameter("id", id)
                .executeUpdate();
    }
}
