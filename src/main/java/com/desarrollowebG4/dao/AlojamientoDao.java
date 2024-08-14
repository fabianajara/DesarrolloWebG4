package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Alojamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlojamientoDao extends JpaRepository<Alojamiento, Long> {

    // Para la parte de filtros de busqueda
    @Query("SELECT a FROM Alojamiento a WHERE "
            + "(:precioInf IS NULL OR a.precioNoche >= :precioInf) AND "
            + "(:precioSup IS NULL OR a.precioNoche <= :precioSup) AND "
            + "(:ubicacion IS NULL OR a.ubicacion = :ubicacion) AND "
            + "(:capacidad IS NULL OR a.capacidad >= :capacidad)")
    List<Alojamiento> filtrarAlojamientos(@Param("precioInf") Double precioInf,
            @Param("precioSup") Double precioSup,
            @Param("ubicacion") String ubicacion,
            @Param("capacidad") Integer capacidad);

}
