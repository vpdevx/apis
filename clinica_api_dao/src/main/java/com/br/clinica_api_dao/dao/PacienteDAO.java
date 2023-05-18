package com.br.clinica_api_dao.dao;

import com.br.clinica_api_dao.connection.DbConnection;
import com.br.clinica_api_dao.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteDAO {

    public List<Paciente> getAll() {
        String sql = "select * from paciente";

        try (Connection con = DbConnection.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Paciente> pacientes = new ArrayList<Paciente>();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getLong("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setEstado(rs.getString("estado"));
                paciente.setData_nascimento(rs.getDate("data_nascimento"));
                paciente.setData_cadastro(rs.getDate("data_cadastro"));
                pacientes.add(paciente);
            }
            rs.close();
            return pacientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Paciente> getById(Long id) {
        String sql = "select * from paciente where id = ?";

        try (Connection con = DbConnection.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getLong("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEmail(rs.getString("email"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setEstado(rs.getString("estado"));
                paciente.setData_nascimento(rs.getDate("data_nascimento"));
                paciente.setData_cadastro(rs.getDate("data_cadastro"));
                rs.close();
                return Optional.of(paciente);
            } else {
                rs.close();
                return Optional.ofNullable(null);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
