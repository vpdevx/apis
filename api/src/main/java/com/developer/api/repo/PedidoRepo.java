package com.developer.api.repo;

import com.developer.api.model.Pedido;
import com.developer.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido as p WHERE p.cliente.id = ?1")
    ArrayList<Pedido> findByClienteId(Long id_cliente);
}
