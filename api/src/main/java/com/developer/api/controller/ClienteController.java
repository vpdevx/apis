package com.developer.api.controller;

import com.developer.api.model.*;
import com.developer.api.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> allClientes() {
        List<Cliente> clientes = clienteService.listarClientes();

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> clienteById(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.listarClientePorId(id);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/{id}/pedidos")
    public ResponseEntity<ArrayList<Pedido>> pedidosPorCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.listarClientePorId(id);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ArrayList<Pedido> pedidosPorCliente = clienteService.listarPedidosPorCliente(cliente.getId());

        return new ResponseEntity<>(pedidosPorCliente, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Cliente> createCliente(Cliente cliente) {
        Cliente clienteCriado = clienteService.criarCliente(cliente);

        return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<Cliente> updateCliente(Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(cliente);

        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteCliente(@PathVariable("id") Long id) {
        clienteService.deletarCliente(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
