package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Disponibilidad;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadService {
    List<Disponibilidad> listarDisponibilidades();
    Optional<Disponibilidad> buscarDisponibilidadPorId(Long id);
    Disponibilidad guardarDisponibilidad(Disponibilidad disponibilidad);
    void eliminarDisponibilidad(Long id);
}