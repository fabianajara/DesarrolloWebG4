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
@RequestMapping("/usuario/alojamientos/filtros")
public class FiltrosBusquedaController {

    @Autowired
    private AlojamientoService alojamientoService;

    // Los metodos significantes son para las pruebas consultas (queries)   
    @GetMapping("")
    public String listadoPropiedades(Model model) {
        var alojamientos = alojamientoService.getAlojamientos(false);
        model.addAttribute("alojamientos", alojamientos);
        return "usuario/alojamientos/filtros/listado";
    }

    @PostMapping("/filtrar")
    public String filtrarAlojamientos(@RequestParam(value = "precioInf", required = false) Double precioInf,
            @RequestParam(value = "precioSup", required = false) Double precioSup,
            @RequestParam(value = "ubicacion", required = false) String ubicacion,
            @RequestParam(value = "capacidad", required = false) Integer capacidad,
            Model model) {

        // Validar parámetros
        if (precioInf == null) {
            precioInf = 0.0; // Valor mínimo
        }
        if (precioSup == null) {
            precioSup = Double.MAX_VALUE; // Valor máximo
        }
        if (capacidad == null) {
            capacidad = 0; // Valor mínimo
        }

        // Llamar al servicio para filtrar alojamientos
        var alojamientos = alojamientoService.filtrarAlojamientos(precioInf, precioSup, ubicacion, capacidad);

        // Agregar los alojamientos filtrados al modelo
        model.addAttribute("alojamientos", alojamientos);

        // Retornar la vista con los resultados
        return "usuario/alojamientos/filtros/listado";
    }
}
