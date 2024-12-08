package com.iudigital.floristeria.controller;

import com.iudigital.floristeria.models.Cliente;
import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.models.Inventario;
import com.iudigital.floristeria.models.Pedido;
import com.iudigital.floristeria.service.InventarioService;
import com.iudigital.floristeria.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {


    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private InventarioService inventarioService;

    // Mostrar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidosService.obtenerTodo());
        return "pedidos";  // Vista
    }

    // Mostrar formulario de creación
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "crearPedido";  // Vista para crear
    }

    // Guardar (crear)
    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Pedido pedido, @ModelAttribute Cliente cliente) {
        // Persistir el pedido si es necesario
        if (pedido.getId() == null) {
            pedidosService.guardar(pedido, cliente);
        }

        List<Inventario> lista = List.of(
                new Inventario("ramo", Map.of(
                        "rosa", 12,
                        "margarita", 8
                )),
                new Inventario("centro_mesa", Map.of(
                        "lirio", 6,
                        "clavel", 10
                )),
                new Inventario("corona", Map.of(
                        "jazmin", 20,
                        "gardenia", 15
                )),
                new Inventario("bouquet", Map.of(
                        "tulipan", 10,
                        "orquidea", 5
                ))
        );

        for (Inventario inventario : lista) {
            if (inventario.getNombre().equals(pedido.getTipoArreglo())) {
                inventario.getFlores().forEach((flor, cantidad) -> {
                    inventarioService.actualizarCantidadDisponible(pedido.getId(), flor, cantidad);
                    inventarioService.calcularPrecioTipoArreglo(pedido.getId(), flor, cantidad);
                });
                break;
            }
        }

        return "redirect:/pedidos";  // Redirigir a la vista
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Pedido pedido = pedidosService.obtenerPorId(id);
        model.addAttribute("pedido", pedido);
        return "editarPedido";  // Vista para editar
    }

    // Actualizar flor (editar)
    @PutMapping("/actualizar/{id}")
    public String actualizarFlor(@PathVariable Long id,@ModelAttribute Pedido pedido) {
        pedidosService.actualizar(id, pedido);

        List<Inventario> lista = List.of(
                new Inventario("ramo", Map.of(
                        "rosa", 12,
                        "margarita", 8
                )),
                new Inventario("Centro de Mesa", Map.of(
                        "lirio", 6,
                        "clavel", 10
                )),
                new Inventario("Corona", Map.of(
                        "jazmin", 20,
                        "gardenia", 15
                )),
                new Inventario("Bouquet", Map.of(
                        "tulipan", 10,
                        "orquidea", 5
                ))
        );

        for (Inventario inventario : lista) {
            if (inventario.getNombre().equals(pedido.getTipoArreglo())) {
                inventario.getFlores().forEach((flor, cantidad) -> {
                    inventarioService.actualizarCantidadDisponible(pedido.getId(), flor, cantidad);
                    inventarioService.calcularPrecioTipoArreglo(pedido.getId(), flor, cantidad);
                });
                break;
            }
        }
        return "redirect:/pedidos";  // Redirigir
    }

    // Eliminar flor
    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable("id") Long id) {
        pedidosService.eliminar(id);
        return "redirect:/pedidos";  // Redirigir
    }

}
