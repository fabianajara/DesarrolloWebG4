package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.ResenaServicio;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.UsuarioServicio;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resenas")
public class ResenaAlojamientoController {

    private static final Logger log = LoggerFactory.getLogger(ResenaAlojamientoController.class);

    @Autowired
    private ResenaServicio resenaServicio;

    @Autowired
    private AlojamientoService alojamientoService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("")
    public String listarResenas(Model model) {
        var resenas = resenaServicio.obtenerTodasLasResenas();
        model.addAttribute("resenas", resenas);
        model.addAttribute("totalResenas", resenas.size());
        return "resenas/listar";
    }

    @GetMapping("/nuevo")
    public String nuevaResena(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("resena", new Resena());
        model.addAttribute("alojamientos", alojamientoService.getAlojamientos(true));
        model.addAttribute("usuarios", usuarioServicio.obtenerTodosLosUsuarios());
        if (error != null) {
            model.addAttribute("error", "Error: " + error);
        }
        return "resenas/modifica";
    }

    @PostMapping("/guardar")
    public String guardarResena(@ModelAttribute Resena resena,
            @RequestParam("idUsuario") Long idUsuario,
            @RequestParam("idAlojamiento") Long idAlojamiento) {
        Optional<Usuario> usuarioOpt = usuarioServicio.buscarUsuarioPorId(idUsuario); // Ajustado a buscarUsuarioPorId
        Optional<Alojamiento> alojamientoOpt = alojamientoService.buscarAlojamientoPorId(idAlojamiento);

        if (usuarioOpt.isPresent() && alojamientoOpt.isPresent()) {
            resena.setUsuario(usuarioOpt.get());
            resena.setAlojamiento(alojamientoOpt.get());
            resenaServicio.guardarResena(resena);
        } else {
            log.error("Usuario o alojamiento no encontrados: usuarioId={}, alojamientoId={}", idUsuario, idAlojamiento);
        }

        return "redirect:/resenas";
    }

    @GetMapping("/eliminar/{idResena}")
    public String eliminarResena(@PathVariable("idResena") Long idResena) {
        resenaServicio.eliminarResena(idResena);
        return "redirect:/resenas";
    }

    @GetMapping("/modificar/{idResena}")
    public String modificarResena(@PathVariable("idResena") Long idResena, Model model) {
        Optional<Resena> resenaOpt = resenaServicio.buscarResenaPorId(idResena);

        if (resenaOpt.isPresent()) {
            Resena resena = resenaOpt.get();
            model.addAttribute("resena", resena);
            model.addAttribute("alojamientos", alojamientoService.getAlojamientos(true));
            model.addAttribute("usuarios", usuarioServicio.obtenerTodosLosUsuarios());
            return "resenas/modifica";
        } else {
            log.error("Reseña no encontrada: idResena={}", idResena);
            return "redirect:/resenas";
        }
    }
}
