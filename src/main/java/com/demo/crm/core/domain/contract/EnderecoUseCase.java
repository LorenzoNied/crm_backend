package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Endereco;

import java.util.List;

public interface EnderecoUseCase {
    public List<Endereco> listarEndereco();
    public Endereco listarEnderecoPorId (int id);
    public void adicionarEndereco (Endereco endereco);
    public String deletarEndereco (int id);
    public String atualizarEndereco (int id, Endereco endereco);

}
