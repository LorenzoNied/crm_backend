package com.demo.crm.infra.repository.dataBase;

import com.demo.crm.core.domain.contract.EnderecoRepository;
import com.demo.crm.core.domain.entity.Endereco;
import com.demo.crm.core.dto.EnderecoInput;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Endereco listarEnderecoPorId(int idCliente) {
        var query = """
                SELECT * FROM endereco WHERE id_cliente = :idCliente;
                """;
        return (Endereco) entityManager.createNativeQuery(query, Endereco.class)
                .setParameter("idCliente", idCliente)
                .getSingleResult();

    }

    @Transactional
    @Override
    public void adicionarEndereco(Endereco endereco, int clienteId) {
        var query = """
                INSERT INTO endereco (rua, numero, bairro, cidade, id_cliente)
                VALUES (:rua, :numero, :bairro, :cidade, :id_cliente)
                """;
        entityManager.createNativeQuery(query, Endereco.class)
                .setParameter("rua", endereco.getRua())
                .setParameter("numero", endereco.getNumero())
                .setParameter("bairro", endereco.getBairro())
                .setParameter("cidade", endereco.getCidade())
                .setParameter("id_cliente", clienteId)
                .executeUpdate();
    }
    @Transactional
    @Override
    public void deletarEndereco(int idCliente) {
        var query = """
                DELETE FROM endereco WHERE id_cliente = :idCliente;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("idCliente", idCliente)
                .executeUpdate();
    }

    @Override
    public void atualizarEndereco(int id, Endereco endereco) {

    }
}
