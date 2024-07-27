package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/usuario/alojamientos") 
public class UsuarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping("")
    public String listadoPropiedades(Model model) {
        var alojamientos = alojamientoService.getAlojamientos(false);
        model.addAttribute("alojamientos", alojamientos);
        return "usuario/alojamientos/listado";
    }

     @GetMapping("/{id}")
    public String verAlojamiento(@PathVariable Long id, Model model) {
        alojamientoService.buscarAlojamientoPorId(id).ifPresent(alojamiento -> {
            model.addAttribute("alojamiento", alojamiento);
        });
        return "usuario/alojamientos/detalle"; // Verifica que la plantilla detalle.html exista
    }
}
