package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Resena;
import java.util.List;

public interface ResenaService {
    
    List<Resena> getAllResenas();

    Resena getResenaById(Long id);

    void saveResena(Resena resena);

    void deleteResena(Long id);
}
