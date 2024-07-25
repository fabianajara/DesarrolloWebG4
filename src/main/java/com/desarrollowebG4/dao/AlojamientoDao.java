package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Alojamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlojamientoDao extends JpaRepository<Alojamiento, Long> {
    
    // para cuando se implementen los filtros de busqueda
    //List<Alojamiento> findByDisponibilidad(boolean disponibilidad);
    //List<Alojamiento> findByNombreContaining(String nombre);
    //List<Alojamiento> findByUbicacionContaining(String ubicacion);
}
