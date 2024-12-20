package com.demo.crm.core.usecase;

import com.demo.crm.core.domain.contract.ClienteRepository;
import com.demo.crm.core.domain.contract.ClienteUseCase;
import com.demo.crm.core.domain.contract.EnderecoRepository;
import com.demo.crm.core.domain.contract.PedidoRepository;
import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.domain.entity.Endereco;
import com.demo.crm.core.domain.entity.Pedido;
import com.demo.crm.core.dto.ClienteInput;
import com.demo.crm.core.dto.EnderecoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.listarCliente();
    }

    @Override
    public ClienteInput listarClientePorId(int id) {
        Cliente cliente = clienteRepository.listarClientePorId(id);
        Endereco endereco = enderecoRepository.listarEnderecoPorId(id);

        EnderecoInput enderecoInput = new EnderecoInput(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade()

        );

        return new ClienteInput(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getTelefone(),
                enderecoInput
        );
    }

    @Override
    public Cliente adicionarCliente(ClienteInput cliente) throws Exception{
        int clienteID = clienteRepository.adicionarCliente(cliente.toEntity());
        enderecoRepository.adicionarEndereco(cliente.endereco().toEntity(),clienteID);

        return null;
    }

    @Override
    public String deletarCliente(int id) throws Exception{

        List<Pedido> pedidos = pedidoRepository.verificarCliente(id);

        if(pedidos.isEmpty()){
            enderecoRepository.deletarEndereco(id);
            clienteRepository.deletarCliente(id);
            return null;
        } else {
            throw new Exception("Não é póssivel deletar cliente que contem pedidos.");
        }
    }

    @Override
    public Cliente atualizarCliente(int id, ClienteInput cliente) throws Exception{
        clienteRepository.atualizarCliente(id, cliente.toEntity());
        enderecoRepository.atualizarEndereco(id, cliente.endereco().toEntity());
        return null;
    }
}

