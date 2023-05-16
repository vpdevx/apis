package com.developer.api.service;

import com.developer.api.model.Pedido;
import com.developer.api.repo.PedidoRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class PedidoService {
    private PedidoRepo pedidoRepo;
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    public Pedido listarPedidoPorId(Long id){
        return pedidoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + id));
    }

    public void deletarPedido(Long id) {
        pedidoRepo.deleteById(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepo.findAll();
    }

}

