package com.iudigital.floristeria.repository;

import com.iudigital.floristeria.models.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FlorRepository extends JpaRepository<Flor, Long> {
    Optional<Flor> findById(Long id);
    Optional<Flor> findByTipoFlor(String tipoFlor);

}

