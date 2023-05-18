package com.br.clinica_api_dao.controller;

import com.br.clinica_api_dao.dao.PacienteDAO;
import com.br.clinica_api_dao.model.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/paciente")
public class PacienteController {

    private PacienteDAO pacienteDAO = new PacienteDAO();

    @GetMapping("/all")
    public List<Paciente> getAll() {
        return pacienteDAO.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getById(@PathVariable("id") Long id) {
        Optional<Paciente>  paciente = pacienteDAO.getById(id);
        return paciente;
    }


}
