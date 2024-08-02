/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.ResenaServicio;
import com.desarrollowebG4.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ResenaAlojamientoController {

    @Autowired
    private ResenaServicio resenaServicio;

    @GetMapping("/resenas")
    public String listarResenas(Model model) {
        model.addAttribute("resenas", resenaServicio.obtenerTodasLasResenas());
        return "resenas/listar";
    }

    @PostMapping("/resenas")
    public String agregarResena(@RequestParam Long idUsuario, @RequestParam Long idAlojamiento,
                                @RequestParam Double calificacion, @RequestParam String comentario) {
        Resena resena = new Resena();
        resena.setUsuario(UsuarioServicio.buscarAlojamientoPorId(idUsuario)); // Asegúrate de implementar este método en el servicio de usuario
        resena.setAlojamiento(AlojamientoService.buscarAlojamientoPorId(idAlojamiento)); // Asegúrate de implementar este método en el servicio de alojamiento
        resena.setCalificacion(calificacion);
        resena.setComentario(comentario);
        resena.setFecha(new Date());
        resenaServicio.guardarResena(resena);
        return "redirect:/resenas";
    }

} 

