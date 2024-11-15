package com.demo.crm.infra.controller;

import com.demo.crm.core.domain.contract.PedidoUseCase;
import com.demo.crm.core.domain.entity.Pedido;
import com.demo.crm.core.dto.PedidoInput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {
    @Autowired
    private PedidoUseCase pedidoUseCase;

    @PostMapping("/pedido")
    ResponseEntity<Pedido> create (@RequestBody @Valid PedidoInput pedido) {
        Pedido pedidoCreated = pedidoUseCase.adicionarPedido(pedido);
        return new ResponseEntity(pedidoCreated, HttpStatus.CREATED);
    }

    @GetMapping("/pedido")
    public List<Pedido> listarPedido (){
        return pedidoUseCase.listarPedido();
    }

    @GetMapping ("/pedido/{id}")
        public PedidoInput listarPedidoPorId (@PathVariable int id){
        return pedidoUseCase.listarPedidoPorId(id);
    }

    @DeleteMapping("/pedido/{id}")
    public void deletarPedido (@PathVariable int id) {
        pedidoUseCase.deletarPedido(id);
    }

    @PutMapping ("/pedido/{id}")
    public void atualizarPedido (@PathVariable int id, @RequestBody Pedido pedido){
        pedidoUseCase.atualizarPedido(id, pedido);
    }

}
