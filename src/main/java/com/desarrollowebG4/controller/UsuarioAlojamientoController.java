package com.desarrollowebG4.controller;

import com.desarrollowebG4.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping("/usuario/alojamientos")
    public String listarAlojamientos(Model model) {
        model.addAttribute("alojamientos", alojamientoService.listarAlojamientos());
        return "usuario/alojamientos/listado"; // Asegúrate de que la plantilla se llama listado.html
    }

    @GetMapping("/usuario/alojamientos/{id}")
    public String verAlojamiento(@PathVariable Long id, Model model) {
        alojamientoService.buscarAlojamientoPorId(id).ifPresent(alojamiento -> {
            model.addAttribute("alojamiento", alojamiento);
        });
        return "usuario/alojamientos/detalle"; // Verifica que la plantilla detalle.html exista
    }
}