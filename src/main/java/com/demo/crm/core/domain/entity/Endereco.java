package com.demo.crm.core.domain.entity;

import jakarta.persistence.*;

@Entity (name = "endereco")
public class Endereco {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "rua")
    private String rua;
    @Column (name = "numero")
    private String numero;
    @Column (name = "bairro")
    private String bairro;
    @Column (name = "cidade")
    private String cidade;
    @Column(name = "id_cliente")
    private int idCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId_cliente() {
        return idCliente;
    }
    public void setId_cliente(int idCliente) {
        this.idCliente = idCliente;
    }
}

