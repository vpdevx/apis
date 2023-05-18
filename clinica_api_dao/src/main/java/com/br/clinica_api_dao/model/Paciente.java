package com.br.clinica_api_dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @ToString
public class Paciente {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private Date data_nascimento;
    private Date data_cadastro;

}
