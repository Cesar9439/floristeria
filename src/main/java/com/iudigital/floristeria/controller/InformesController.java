package com.iudigital.floristeria.controller;

import org.springframework.ui.Model;
import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.service.InventarioService;
import com.iudigital.floristeria.service.PedidosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/informes")
public class InformesController {

    private final PedidosService pedidosService;

    private final InventarioService florService;

    public InformesController(PedidosService pedidosService, InventarioService florService) {
        this.pedidosService = pedidosService;
        this.florService = florService;
    }

    @GetMapping("/popularidad-arreglos")
    public String getPopularidadArreglos(Model model) {
        List<Object[]> popularidadArreglos = pedidosService.getArrangementPopularity();
        model.addAttribute("popularidadArreglos", popularidadArreglos);
        return "popularidad-arreglos";
    }

    @GetMapping("/ingresos-por-cliente")
    public String getIngresosPorCliente(Model model) {
        List<Object[]> ingresosPorCliente = pedidosService.getFindIncomeByClient();
        model.addAttribute("ingresosPorCliente", ingresosPorCliente);
        return "ingresos-por-cliente";
    }
}
