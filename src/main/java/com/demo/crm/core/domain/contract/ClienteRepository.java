package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    public List<Cliente> listarCliente();
    public Cliente listarClientePorId (int id);
    public int adicionarCliente (Cliente cliente);
    public void deletarCliente (int id);
    public void atualizarCliente (int id, Cliente cliente);

}
