package com.demo.crm.infra.controller;

import com.demo.crm.core.domain.contract.ClienteUseCase;
import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.dto.ClienteInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping("/cliente")
    ResponseEntity<Cliente> create (@RequestBody @Valid ClienteInput cliente) {
        Cliente clienteCreated = clienteUseCase.adicionarCliente(cliente);
        return new ResponseEntity(clienteCreated, HttpStatus.CREATED);
    }

    @GetMapping("/cliente")
    public List<Cliente> listarCliente (){
        return clienteUseCase.listarCliente();
    }

    @GetMapping ("/cliente/{id}")
    public ClienteInput listarClientePorId (@PathVariable int id){
        return clienteUseCase.listarClientePorId(id);
    }

    @DeleteMapping("/cliente/{id}")
    public void deletarCliente (@PathVariable int id) {
        clienteUseCase.deletarCliente(id);
    }

    @PutMapping ("/cliente/{id}")
    public void atualizarCliente (@PathVariable int id, @RequestBody ClienteInput cliente){
        clienteUseCase.atualizarCliente(id, cliente);
    }

}
