package com.iudigital.floristeria.service;

import com.iudigital.floristeria.models.Cliente;
import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.models.Pedido;
import com.iudigital.floristeria.repository.ClienteRepository;
import com.iudigital.floristeria.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos
    public List<Pedido> obtenerTodo() {
        return pedidosRepository.findAll();
    }

    // Guardar
    public void guardar(Pedido pedido, Cliente cliente) {
        clienteRepository.save(cliente);
        pedidosRepository.save(pedido);
    }

    // Obtener por su ID
    public Pedido obtenerPorId(Long id) {
        Optional<Pedido> pedido = pedidosRepository.findById(id);
        return pedido.orElseThrow(() -> new RuntimeException("Pedido no encontrada"));
    }

    // Actualizar existente
    public void actualizar(Long id, Pedido pedido) {
        Optional<Pedido> existing = pedidosRepository.findById(id);
        if (existing.isPresent()) {
            Pedido updated = existing.get();
            updated.setTipoArreglo(pedido.getTipoArreglo());
            updated.setOcasion(pedido.getOcasion());
            updated.setFechaEntrega(pedido.getFechaEntrega());
            updated.setPresupuesto(pedido.getPresupuesto());
            updated.setEstado(pedido.getEstado());

            pedidosRepository.save(updated);
        }
    }

    // Eliminar
    public void eliminar(Long id) {
        pedidosRepository.deleteById(id);
    }
}
