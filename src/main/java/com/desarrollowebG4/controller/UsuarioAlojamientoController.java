package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.AlojamientoService;
import java.util.Optional;
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
        var alojamientos = alojamientoService.getAlojamientos(true);
        model.addAttribute("alojamientos", alojamientos);
        return "usuario/alojamientos/listado";
    }
    
    @GetMapping("/{id}")
    public String verAlojamiento(@PathVariable("id") Long id, Model model) {
        Optional<Alojamiento> optionalAlojamiento = alojamientoService.buscarAlojamientoPorId(id);
        if (optionalAlojamiento.isPresent()) {
            Alojamiento alojamiento = optionalAlojamiento.get();
            Usuario anfitrion = alojamiento.getAnfitrion();
            System.out.println("Anfitrion: " + (anfitrion != null ? anfitrion.getNombre() : "null"));
            model.addAttribute("alojamiento", alojamiento);
            model.addAttribute("anfitrion", anfitrion);
            return "usuario/alojamientos/detalle";
        } else {
            model.addAttribute("error", "Alojamiento no encontrado");
            return "usuario/alojamientos";
        }
    }
}
