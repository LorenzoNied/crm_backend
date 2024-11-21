package com.demo.crm.core.domain.contract;

import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.dto.ClienteInput;

import java.util.List;

public interface ClienteUseCase {
    public List<Cliente> listarCliente();
    public ClienteInput listarClientePorId (int id);
    public Cliente adicionarCliente (ClienteInput cliente) throws Exception;
    public Cliente deletarCliente (int id) throws Exception;
    public Cliente atualizarCliente (int id, ClienteInput cliente) throws Exception;

}
