package com.iudigital.floristeria.service;

import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private FlorRepository florRepository;

    // Obtener todas las flores
    public List<Flor> obtenerTodasLasFlores() {
        return florRepository.findAll();
    }

    // Guardar una nueva flor
    public void guardarFlor(Flor flor) {
        florRepository.save(flor);
    }

    // Obtener una flor por su ID
    public Flor obtenerFlorPorId(Long id) {
        Optional<Flor> flor = florRepository.findById(id);
        return flor.orElseThrow(() -> new RuntimeException("Flor no encontrada"));
    }

    // Actualizar una flor existente
    public void actualizarFlor(Long id, Flor flor) {
        Optional<Flor> existingFlor = florRepository.findById(id);
        if (existingFlor.isPresent()) {
            Flor updatedFlor = existingFlor.get();
            updatedFlor.setTipoFlor(flor.getTipoFlor());
            updatedFlor.setColor(flor.getColor());
            updatedFlor.setVariedad(flor.getVariedad());
            updatedFlor.setCantidadDisponible(flor.getCantidadDisponible());
            updatedFlor.setPrecioCompra(flor.getPrecioCompra());
            updatedFlor.setPrecioVenta(flor.getPrecioVenta());
            florRepository.save(updatedFlor);
        }
    }

    // Eliminar una flor
    public void eliminarFlor(Long id) {
        florRepository.deleteById(id);
    }
}