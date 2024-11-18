package com.demo.crm.core.dto;

import com.demo.crm.core.domain.entity.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public record ClienteInput(
        int id,
        @NotNull(message= "Preencha o nome, não pode ser nulo!")
        @NotBlank(message= "Preencha o nome, não pode ser vazio!")
        @Size(max = 50, message = "O limite maximo é de 50 caracteres.")
        String nome,
        @NotNull(message = "Preencha o CPF, não pode ser nulo!")
        @NotBlank(message= "Preencha o CPF, não pode ser vazio!")
        @Size(min =11, max = 11, message = "O limite é 11 caracteres.")
        String cpf,
        String telefone,
        EnderecoInput endereco

) { public Cliente toEntity (){
    Cliente cliente = new Cliente();
    cliente.setId(id);
    cliente.setNome(nome);
    cliente.setCpf(cpf);
    cliente.setTelefone(telefone);
    return cliente;
}
}

