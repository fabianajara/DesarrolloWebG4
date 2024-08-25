package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.FirebaseStorageService;
import com.desarrollowebG4.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario/perfil")
public class UsuarioPerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String verPerfil(Model model) {
        // Obtener el usuario actual
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        model.addAttribute("usuario", usuario);
        return "usuario/perfil/ver";
    }

    @GetMapping("/editar")
    public String editarPerfil(Model model) {
        // Obtener el usuario actual
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        model.addAttribute("usuario", usuario);
        return "usuario/perfil/editar";
    }

    @PostMapping("/guardar")
    public String guardarPerfil(Usuario usuario) {
        // Obtener el usuario actual
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Usuario usuarioActual = usuarioService.getUsuarioPorUsername(username);

        // Actualizar el perfil del usuario actual
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setCorreo(usuario.getCorreo());
        usuarioActual.setTelefono(usuario.getTelefono());

        usuarioService.save(usuarioActual, false);
        return "redirect:/usuario/perfil";
    }

    @PostMapping("/eliminar")
    public String eliminarPerfil() {
        // Obtener el usuario actual
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        // Eliminar el perfil del usuario actual
        usuarioService.delete(usuario);
        return "redirect:/logout";
    }
}
