package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.FotoAlojamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoAlojamientoDao extends JpaRepository<FotoAlojamiento, Long> {
    List<FotoAlojamiento> findByAlojamiento(Alojamiento alojamiento);
}