package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.domain.entity.Endereco;

import java.util.List;

public interface EnderecoRepository {
    public Endereco listarEnderecoPorId (int idCliente);
    public void adicionarEndereco (Endereco endereco, int clienteId);
    public void deletarEndereco (int id);
    public void atualizarEndereco (int id, Endereco endereco);

}
