package com.demo.crm.core.dto;

import com.demo.crm.core.domain.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoInput(
        String rua,
        String numero,
        String bairro,
        String cidade
) {
    public Endereco toEntity(){
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        return endereco;
    }
}
