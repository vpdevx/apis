package com.developer.api.service;

import com.developer.api.model.Cliente;
import com.developer.api.model.Pedido;
import com.developer.api.repo.ClienteRepo;
import com.developer.api.repo.PedidoRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepo clienteRepo;
    private PedidoRepo pedidoRepo;
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    public ArrayList<Pedido> listarPedidosPorCliente(Long id) {
        return pedidoRepo.findByClienteId(id);
    }
    public Cliente listarClientePorId(Long id){
        return clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
    }
    public void deletarCliente(Long id) {
        clienteRepo.deleteById(id);
    }

}
