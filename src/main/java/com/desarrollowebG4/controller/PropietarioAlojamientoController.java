
package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@Controller
//@RequestMapping("/propietario/alojamientos")
//public class PropietarioAlojamientoController {
//
//    @Autowired
//    private AlojamientoService alojamientoService;
//
//    @GetMapping
//    public String listarAlojamientos(Model model) {
//        model.addAttribute("alojamientos", alojamientoService.listarAlojamientos());
//        return "propietario/alojamientos/list";
//    }
//
//    @GetMapping("/nuevo")
//    public String mostrarFormularioDeCrearAlojamiento(Model model) {
//        model.addAttribute("alojamiento", new Alojamiento());
//        return "propietario/alojamientos/form";
//    }
//
//    @PostMapping("/guardar")
//    public String guardarAlojamiento(@ModelAttribute Alojamiento alojamiento) {
//        alojamientoService.guardarAlojamiento(alojamiento);
//        return "redirect:/propietario/alojamientos";
//    }
//
//    @GetMapping("/editar/{id}")
//    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
//        alojamientoService.buscarAlojamientoPorId(id).ifPresent(alojamiento -> {
//            model.addAttribute("alojamiento", alojamiento);
//        });
//        return "propietario/alojamientos/form";
//    }
//
//    @PostMapping("/editar/{id}")
//    public String actualizarAlojamiento(@PathVariable Long id, @ModelAttribute Alojamiento alojamiento) {
//        alojamiento.setIdAlojamiento(id);
//        alojamientoService.guardarAlojamiento(alojamiento);
//        return "redirect:/propietario/alojamientos";
//    }
//
//    @GetMapping("/eliminar/{id}")
//    public String eliminarAlojamiento(@PathVariable Long id) {
//        alojamientoService.eliminarAlojamiento(id);
//        return "redirect:/propietario/alojamientos";
//    }
//}
@Controller
@Slf4j
@RequestMapping("/propietario/alojamientos") 
public class PropietarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("")
    public String listadoPropiedades(Model model) {
        var alojamientos = alojamientoService.getAlojamientos(false);
        model.addAttribute("alojamientos", alojamientos);
        model.addAttribute("totalAlojamientos", alojamientos.size());
        return "propietario/alojamientos/listado"; 
    }

    @GetMapping("/nuevo")
    public String nuevoAlojamiento(Alojamiento alojamiento) {
        return "propietario/alojamientos/modifica"; 
    }

    @PostMapping("/guardar")
    public String guardarAlojamiento(Alojamiento alojamiento,
                                     @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            alojamientoService.save(alojamiento);
            alojamiento.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "alojamiento",
                            alojamiento.getIdAlojamiento()));
        }
        alojamientoService.save(alojamiento);
        return "redirect:/propietario/alojamientos"; // Redirige al listado
    }

    @GetMapping("/eliminar/{idAlojamiento}")
    public String eliminarAlojamiento(@PathVariable("idAlojamiento") Long idAlojamiento) {
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setIdAlojamiento(idAlojamiento);
        alojamientoService.delete(alojamiento);
        return "redirect:/propietario/alojamientos"; // Redirige al listado
    }

    @GetMapping("/modificar/{idAlojamiento}")
    public String modificarAlojamiento(@PathVariable("idAlojamiento") Long idAlojamiento, Model model) {
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setIdAlojamiento(idAlojamiento);
        alojamiento = alojamientoService.getAlojamiento(alojamiento);
        model.addAttribute("alojamiento", alojamiento);
        return "propietario/alojamientos/modifica"; // Sin la barra inicial
    }
}
