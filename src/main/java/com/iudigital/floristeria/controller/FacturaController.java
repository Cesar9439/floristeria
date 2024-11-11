package com.iudigital.floristeria.controller;

import com.iudigital.floristeria.models.Entrega;
import com.iudigital.floristeria.models.Pedido;
import com.iudigital.floristeria.repository.PedidosRepository;
import com.iudigital.floristeria.service.EntregasService;
import com.iudigital.floristeria.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/facturacion")
public class FacturaController {

    @Autowired
    private PedidosService pedidosService;
    @Autowired
    private PedidosRepository pedidosRepository;

    // Mostrar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidosService.obtenerTodo());
        return "facturacion";  // Vista
    }

    // Mostrar formulario de edición
    @GetMapping("/factura/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Pedido pedido = pedidosService.obtenerPorId(id);
        model.addAttribute("pedidos", pedido);
        return "factura";  // Vista para editar
    }
}
