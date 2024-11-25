package com.demo.crm.infra.controller;

import ch.qos.logback.core.net.server.Client;
import com.demo.crm.core.domain.contract.ClienteUseCase;
import com.demo.crm.core.domain.entity.Cliente;
import com.demo.crm.core.dto.ClienteInput;
import com.demo.crm.global.ValidationErrorResponse;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping("/cliente")
    ResponseEntity<String> create (@RequestBody @Valid ClienteInput cliente) {
        try {
            Cliente clienteCreated = clienteUseCase.adicionarCliente(cliente);
            return new ResponseEntity("Cliente criado com sucesso!!", HttpStatus.CREATED);
        } catch (Exception e){
            if (e.getMessage().contains("duplicate key")) {
                return new ResponseEntity<>("Este CPF já está cadastrado.", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Erro inesperado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/cliente")
    public List<Cliente> listarCliente (){
        return clienteUseCase.listarCliente();
    }

    @GetMapping ("/cliente/{id}")
    public ClienteInput listarClientePorId (@PathVariable int id) {
        return clienteUseCase.listarClientePorId(id);
    }

    @DeleteMapping("/cliente/{id}")
    ResponseEntity<String> deletarCliente (@PathVariable int id) {
        try {
            String resposta = clienteUseCase.deletarCliente(id);
            return new ResponseEntity(resposta, HttpStatus.OK);
        } catch (Exception e){
            if(e.getMessage().contains("foreign key")){
                return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping ("/cliente/{id}")
    ResponseEntity<Cliente> atualizarCliente (@PathVariable int id, @RequestBody ClienteInput cliente){
        try {
            Cliente atualizarCliente = clienteUseCase.atualizarCliente(id, cliente);
            return new ResponseEntity(atualizarCliente, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
