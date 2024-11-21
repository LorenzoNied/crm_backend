package com.demo.crm.core.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "pedido")
public class Pedido {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "id_cliente")
    private int idCliente;
    @Column (name = "status")
    private String status;
    @Column (name = "valor")
    private int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
