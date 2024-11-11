package com.iudigital.floristeria.repository;

import com.iudigital.floristeria.models.Flor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlorRepository extends JpaRepository<Flor, Long> {
    Optional<Flor> findById(Long id);
}
