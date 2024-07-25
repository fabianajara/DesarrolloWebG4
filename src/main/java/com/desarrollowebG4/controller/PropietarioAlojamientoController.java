
package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/propietario/alojamientos")
public class PropietarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping
    public String listarAlojamientos(Model model) {
        model.addAttribute("alojamientos", alojamientoService.listarAlojamientos());
        return "propietario/alojamientos/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearAlojamiento(Model model) {
        model.addAttribute("alojamiento", new Alojamiento());
        return "propietario/alojamientos/form";
    }

    @PostMapping("/guardar")
    public String guardarAlojamiento(@ModelAttribute Alojamiento alojamiento) {
        alojamientoService.guardarAlojamiento(alojamiento);
        return "redirect:/propietario/alojamientos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        alojamientoService.buscarAlojamientoPorId(id).ifPresent(alojamiento -> {
            model.addAttribute("alojamiento", alojamiento);
        });
        return "propietario/alojamientos/form";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAlojamiento(@PathVariable Long id, @ModelAttribute Alojamiento alojamiento) {
        alojamiento.setIdAlojamiento(id);
        alojamientoService.guardarAlojamiento(alojamiento);
        return "redirect:/propietario/alojamientos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlojamiento(@PathVariable Long id) {
        alojamientoService.eliminarAlojamiento(id);
        return "redirect:/propietario/alojamientos";
    }
}