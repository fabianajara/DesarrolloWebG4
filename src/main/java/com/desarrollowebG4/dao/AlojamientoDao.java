package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Alojamiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlojamientoDao extends JpaRepository<Alojamiento, Long> {

}
