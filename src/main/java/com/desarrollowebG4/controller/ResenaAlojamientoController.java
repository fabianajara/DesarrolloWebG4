package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.ResenaService;
import com.desarrollowebG4.service.UsuarioService;
import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("usuario/resenas")
public class ResenaAlojamientoController {

   @Autowired
    private ResenaService ResenaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping
    public String listarResenas(Model model) {
        model.addAttribute("resenas", ResenaService.obtenerTodasLasResenas());
        return "listado"; // Llama a listado.html para renderizar la vista completa
    }

    @GetMapping("/nuevo")
    public String nuevaResena(Model model) {
        model.addAttribute("resena", new Resena());
        model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
        model.addAttribute("alojamientos", alojamientoService.obtenerTodosLosAlojamientos());
        return "fragmento :: nuevaResena"; // Renderiza el fragmento para agregar nueva reseña
    }

    @PostMapping("/guardar")
    public String guardarResena(@ModelAttribute Resena resena) {
        ResenaService.guardarResena(resena);
        return "redirect:/usuario/resenas"; // Redirige a la lista de reseñas
    }

    @GetMapping("/modificar/{idResena}")
    public String modificarResena(@PathVariable Long idResena, Model model) {
        Optional<Resena> resenaOptional = ResenaService.buscarResenaPorId(idResena);
        if (resenaOptional.isPresent()) {
            model.addAttribute("resena", resenaOptional.get());
            model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
            model.addAttribute("alojamientos", alojamientoService.obtenerTodosLosAlojamientos());
            return "fragmento :: modificarResena"; // Renderiza el fragmento para modificar reseña
        }
        return "redirect:/usuario/resenas"; // Redirige si no se encuentra la reseña
    }

    @GetMapping("/eliminar/{idResena}")
    public String eliminarResena(@PathVariable Long idResena) {
        ResenaService.eliminarResena(idResena);
        return "redirect:/usuario/resenas"; // Redirige a la lista de reseñas después de eliminar
    }
}