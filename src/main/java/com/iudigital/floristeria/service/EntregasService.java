package com.iudigital.floristeria.service;

import com.iudigital.floristeria.models.Cliente;
import com.iudigital.floristeria.models.Entrega;
import com.iudigital.floristeria.models.Pedido;
import com.iudigital.floristeria.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregasService {
    @Autowired
    private EntregaRepository entregaRepository;

    // Obtener todos
    public List<Entrega> obtenerTodo() {
        return entregaRepository.findAll();
    }

    // Guardar
    public void guardar(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    // Obtener por su ID
    public Entrega obtenerPorId(Long id) {
        Optional<Entrega> entrega = entregaRepository.findById(id);
        return entrega.orElseThrow(() -> new RuntimeException("Pedido no encontrada"));
    }

    // Actualizar existente
    public void actualizar(Long id, Entrega entrega) {
        Optional<Entrega> existing = entregaRepository.findById(id);
        if (existing.isPresent()) {
            Entrega updated = existing.get();
            updated.setNombre(entrega.getNombre());
            updated.setRuta(entrega.getRuta());

            entregaRepository.save(updated);
        }
    }

    // Eliminar
    public void eliminar(Long id) {
        entregaRepository.deleteById(id);
    }
}
