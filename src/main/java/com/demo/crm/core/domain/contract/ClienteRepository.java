package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Carrinho;
import com.demo.crm.core.domain.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    public List<Cliente> listarCliente();
    public Cliente listarClientePorId (int id);
    public void adicionarCliente (Cliente cliente);
    public String deletarCliente (int id);
    public String atualizarCliente (int id, Cliente cliente);

}
