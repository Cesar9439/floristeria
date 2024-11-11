package com.iudigital.floristeria.controller;

import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Mostrar el inventario
    @GetMapping
    public String listarInventario(Model model) {
        model.addAttribute("flores", inventarioService.obtenerTodasLasFlores());
        return "inventario";  // Vista de inventario
    }

    // Mostrar formulario de creación de una nueva flor
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("flor", new Flor());
        return "crearFlor";  // Vista para crear una nueva flor
    }

    // Guardar nueva flor (crear)
    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Flor flor) {
        inventarioService.guardarFlor(flor);
        return "redirect:/inventario";  // Redirigir a la vista del inventario
    }

    // Mostrar formulario de edición de una flor existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable("id") Long id, Model model) {
        Flor flor = inventarioService.obtenerFlorPorId(id);
        model.addAttribute("flor", flor);
        return "editarFlor";  // Vista para editar flor
    }

    // Actualizar flor (editar)
    @PutMapping("/actualizar/{id}")
    public String actualizarFlor(@PathVariable Long id,@ModelAttribute Flor flor) {
        inventarioService.actualizarFlor(id, flor);
        return "redirect:/inventario";  // Redirigir al inventario
    }

    // Eliminar flor
    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable("id") Long id) {
        inventarioService.eliminarFlor(id);
        return "redirect:/inventario";  // Redirigir al inventario
    }
}
