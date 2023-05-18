package com.br.clinica_api_dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @ToString
public class Medico {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String crm;
    private String especialidade;
    private Date data_cadastro;
}
