package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.dto.ClienteInput;

import java.util.List;

public interface ClienteUseCase {
    public List<Cliente> listarCliente();
    public ClienteInput listarClientePorId (int id);
    public Cliente adicionarCliente (ClienteInput cliente);
    public void deletarCliente (int id);
    public void atualizarCliente (int id, Cliente cliente);

}
