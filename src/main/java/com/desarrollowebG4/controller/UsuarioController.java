package com.desarrollowebG4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/iniciar")
    public String iniciar(Model model) {
        return "/usuario/iniciar";
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestParam String email, @RequestParam String contrasena) {
        Usuario usuarioBD = usuarioService.getUsuarioPorEmailYContrasena(email, contrasena);

        if (usuarioBD != null) {
            return "redirect:/usuario/listado";
        } else {
            return "redirect:/usuario/iniciar?error";
        }
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/usuario/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario, false); // No se crea rol automáticamente
        return "redirect:/usuario/listado";
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = usuarioService.getUsuarios();
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarios", lista.size());
        return "/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String eliminar(@PathVariable Long idUsuario) {
        usuarioService.deleteUsuario(idUsuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String modificar(@PathVariable Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuario(idUsuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificar";
    }
}
