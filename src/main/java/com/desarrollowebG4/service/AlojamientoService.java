package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Alojamiento;
import java.util.List;
import java.util.Optional;

public interface AlojamientoService {

    // Service general para los aloamientos
    List<Alojamiento> listarAlojamientos();

    Optional<Alojamiento> buscarAlojamientoPorId(Long id);

    Alojamiento guardarAlojamiento(Alojamiento alojamiento);

    void eliminarAlojamiento(Long id);
}
