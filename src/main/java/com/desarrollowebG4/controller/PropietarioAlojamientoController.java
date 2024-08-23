package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.AlojamientoService;
import com.desarrollowebG4.service.UsuarioDetailsService;
import com.desarrollowebG4.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/propietario/alojamientos")
public class PropietarioAlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    private String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return authentication.getPrincipal().toString();
    }

    @GetMapping("")
    public String listadoPropiedades(Model model) {
        String username = getAuthenticatedUsername();
        List<Alojamiento> alojamientos = alojamientoService.findByAnfitrionUsername(username);
        model.addAttribute("alojamientos", alojamientos);
        model.addAttribute("totalAlojamientos", alojamientos.size());
        return "propietario/alojamientos/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoAlojamiento(Alojamiento alojamiento) {
        return "propietario/alojamientos/modifica";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ANFITRION')")
    public String guardarAlojamiento(Alojamiento alojamiento,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        String username = getAuthenticatedUsername();
        Usuario usuario = usuarioDetailsService.findByUsername(username);

        // Asigna el usuario autenticado como el anfitrión del alojamiento
        alojamiento.setAnfitrion(usuario);

        if (alojamiento.getIdAlojamiento() != null) {
            Alojamiento alojamientoExistente = alojamientoService.getAlojamiento(alojamiento);

            if (alojamientoExistente != null) {
                alojamientoExistente.setNombre(alojamiento.getNombre());
                alojamientoExistente.setDescripcion(alojamiento.getDescripcion());
                alojamientoExistente.setAlojamientoTipo(alojamiento.getAlojamientoTipo());
                alojamientoExistente.setNumHabitaciones(alojamiento.getNumHabitaciones());
                alojamientoExistente.setNumBanos(alojamiento.getNumBanos());
                alojamientoExistente.setCapacidad(alojamiento.getCapacidad());
                alojamientoExistente.setPrecioNoche(alojamiento.getPrecioNoche());
                alojamientoExistente.setUbicacion(alojamiento.getUbicacion());
                alojamientoExistente.setCalificacion(alojamiento.getCalificacion());
                alojamientoExistente.setActivo(alojamiento.isActivo());

                if (alojamiento.getFotos() != null) {
                    alojamientoExistente.getFotos().clear();
                    alojamientoExistente.getFotos().addAll(alojamiento.getFotos());
                }

                alojamiento = alojamientoExistente;
            }
        }

        if (!imagenFile.isEmpty()) {
            alojamientoService.save(alojamiento);
            alojamiento.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "alojamiento",
                            alojamiento.getIdAlojamiento()));
        }
        alojamientoService.save(alojamiento);
        return "/propietario/alojamientos/listado";
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
