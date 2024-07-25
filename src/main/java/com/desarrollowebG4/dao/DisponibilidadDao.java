
package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Disponibilidad;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DisponibilidadDao extends JpaRepository<Disponibilidad, Long> {
    List<Disponibilidad> findByAlojamientoIdAlojamiento(Long idAlojamiento);
    List<Disponibilidad> findByFechaInicioBeforeAndFechaFinAfter(Date fechaInicio, Date fechaFin);
}