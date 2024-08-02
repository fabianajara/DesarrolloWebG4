package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Alojamiento;
import java.util.List;
import java.util.Optional;

public interface AlojamientoService {

    public List<Alojamiento> getAlojamientos(boolean activos);
    public Alojamiento getAlojamiento(Alojamiento alojamiento);
    Optional<Alojamiento> buscarAlojamientoPorId(Long id);
    public void save(Alojamiento alojamiento);
    public void delete(Alojamiento alojamiento);

}
