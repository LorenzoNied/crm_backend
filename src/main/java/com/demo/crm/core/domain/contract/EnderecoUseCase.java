package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Endereco;

public interface EnderecoUseCase {
    public Endereco listarEnderecoPorId (int idCliente);
    public void adicionarEndereco (Endereco endereco);
    public Void deletarEndereco (int id);
    public Void atualizarEndereco (int id, Endereco endereco);
}