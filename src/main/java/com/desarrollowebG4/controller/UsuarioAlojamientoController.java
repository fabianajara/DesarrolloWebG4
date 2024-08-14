package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.FotoAlojamiento;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.FotoAlojamientoService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/usuario/alojamientos")
public class UsuarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;
    
    @Autowired
    private FotoAlojamientoService fotoAlojamientoService;

    // Método para mostrar el listado general de alojamientos
    @GetMapping("")
    public String listadoPropiedades(Model model) {
        var alojamientos = alojamientoService.getAlojamientos(true);
        model.addAttribute("alojamientos", alojamientos);
        return "usuario/alojamientos/listado";
    }

//    @GetMapping("/{id}")
//    public String verAlojamiento(@PathVariable("id") Long id, Model model) {
//        Optional<Alojamiento> optionalAlojamiento = alojamientoService.buscarAlojamientoPorId(id);
//        if (optionalAlojamiento.isPresent()) {
//            Alojamiento alojamiento = optionalAlojamiento.get();
//            Usuario anfitrion = alojamiento.getAnfitrion();
//            System.out.println("Anfitrion: " + (anfitrion != null ? anfitrion.getNombre() : "null"));
//            model.addAttribute("alojamiento", alojamiento);
//            model.addAttribute("anfitrion", anfitrion);
//            model.addAttribute("fotos", alojamiento.getFotos());
//            return "usuario/alojamientos/detalle";
//        } else {
//            model.addAttribute("error", "Alojamiento no encontrado");
//            return "usuario/alojamientos";
//        }
//    }
    
    // Método para ver detalles de un alojamiento específico
    @GetMapping("/{id}")
    public String verAlojamiento(@PathVariable("id") Long id, Model model) {
        Optional<Alojamiento> optionalAlojamiento = alojamientoService.buscarAlojamientoPorId(id);
        if (optionalAlojamiento.isPresent()) {
            Alojamiento alojamiento = optionalAlojamiento.get();
            Usuario anfitrion = alojamiento.getAnfitrion();
            List<FotoAlojamiento> fotos = fotoAlojamientoService.findFotosByAlojamiento(alojamiento);
            model.addAttribute("alojamiento", alojamiento);
            model.addAttribute("anfitrion", anfitrion);
            model.addAttribute("fotos", fotos);
            return "usuario/alojamientos/detalle";
        } else {
            model.addAttribute("error", "Alojamiento no encontrado");
            return "usuario/alojamientos";
        }
    }
}
