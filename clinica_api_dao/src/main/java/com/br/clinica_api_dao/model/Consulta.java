package com.br.clinica_api_dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @ToString
public class Consulta {
    private Long id;
    private LocalDateTime data_consulta;
    private String observacoes;
    private Paciente paciente;
    private Medico medico;
}
