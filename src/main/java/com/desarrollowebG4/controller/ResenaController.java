package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/resenas")
public class ResenaController {

    private final ResenaService resenaService;

    @Autowired
    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Resena> listaResenas = resenaService.getAllResenas();
        model.addAttribute("resenas", listaResenas);
        model.addAttribute("totalResenas", listaResenas.size());
        return "resena/listado"; // Ajusta la ruta según la estructura de tus vistas
    }

    // Ejemplo de método para agregar una nueva reseña
    @PostMapping("/agregar")
    public String agregarResena(@RequestParam String comentario,
            @RequestParam double calificacion,
            Model model) {
        Resena nuevaResena = new Resena();
        nuevaResena.setComentario(comentario);
        nuevaResena.setCalificacion(calificacion);

        resenaService.saveResena(nuevaResena);

        return "redirect:/resenas/listado";
    }

    // Otros métodos para editar, eliminar, etc. según sea necesario AGREGAR LUEGOS
}
