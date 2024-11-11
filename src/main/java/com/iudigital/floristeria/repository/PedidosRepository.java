package com.iudigital.floristeria.repository;

import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findById(Long id);
}
