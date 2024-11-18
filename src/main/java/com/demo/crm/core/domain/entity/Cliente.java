package com.demo.crm.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    private int id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "cpf")
    private String cpf;
    @Column (name = "telefone")
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
        this.nome = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telephone) {
        this.telefone = telephone;
    }

}
