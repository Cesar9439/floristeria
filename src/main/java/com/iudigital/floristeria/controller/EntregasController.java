package com.iudigital.floristeria.controller;

import com.iudigital.floristeria.models.Cliente;
import com.iudigital.floristeria.models.Entrega;
import com.iudigital.floristeria.models.Pedido;
import com.iudigital.floristeria.repository.PedidosRepository;
import com.iudigital.floristeria.service.EntregasService;
import com.iudigital.floristeria.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entregas")
public class EntregasController {

    @Autowired
    private EntregasService entregasService;
    @Autowired
    private PedidosRepository pedidosRepository;

    // Mostrar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entregas", entregasService.obtenerTodo());
        return "entregas";  // Vista
    }

    // Mostrar formulario de creación
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        List<Pedido> pedidos = pedidosRepository.findAll();
        // Obtiene todos los pedidos de la base de datos
        model.addAttribute("pedidos", pedidos);  // Añade la lista de pedidos al modelo
        model.addAttribute("entrega", new Entrega());
        return "crearEntrega";  // Vista para crear
    }

    // Guardar (crear)
    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Entrega entrega, @RequestParam("pedido.id") Long pedidoId) {
        Pedido pedido = pedidosRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        entrega.setPedido(pedido);
        entregasService.guardar(entrega);
        return "redirect:/entregas";  // Redirigir a la vista
    }

    // Mostrar formulario de edición
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Entrega entrega = entregasService.obtenerPorId(id);
        model.addAttribute("entrega", entrega);
        return "editarEntrega";  // Vista para editar
    }

    // Actualizar flor (editar)
    @PutMapping("/actualizar/{id}")
    public String actualizarFlor(@PathVariable Long id,@ModelAttribute Entrega entrega) {
        entregasService.actualizar(id, entrega);
        return "redirect:/entregas";  // Redirigir
    }

    // Eliminar flor
    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable("id") Long id) {
        entregasService.eliminar(id);
        return "redirect:/entregas";  // Redirigir
    }
}
