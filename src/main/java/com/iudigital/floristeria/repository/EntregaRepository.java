package com.iudigital.floristeria.repository;

import com.iudigital.floristeria.models.Entrega;
import com.iudigital.floristeria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    Optional<Entrega> findById(Long id);
}
