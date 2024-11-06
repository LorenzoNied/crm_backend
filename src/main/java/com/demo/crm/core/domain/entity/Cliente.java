package com.demo.crm.core.domain.entity;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String enderecoId;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(String enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telephone) {
        this.telefone = telefone;
    }
}
