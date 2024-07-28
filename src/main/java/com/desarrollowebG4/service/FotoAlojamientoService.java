package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.FotoAlojamiento;
import java.util.List;

public interface FotoAlojamientoService {
    List<FotoAlojamiento> findFotosByAlojamiento(Alojamiento alojamiento);
}
