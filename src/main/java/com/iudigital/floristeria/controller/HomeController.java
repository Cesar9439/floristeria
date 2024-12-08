package com.iudigital.floristeria.controller;

import com.iudigital.floristeria.service.PedidosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private PedidosService pedidosService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/factura")
    public String factura() {
        return "factura";
    }

    @GetMapping("/informes")
    public String informes() {
        return "informes";
    }
}
