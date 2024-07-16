package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.ResenaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResenaServiceImpl implements ResenaService {

    private List<Resena> resenas = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Resena> getAllResenas() {
        return resenas;
    }

    @Override
    public Resena getResenaById(Long id) {
        return resenas.stream()
                .filter(r -> r.getIdResena().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveResena(Resena resena) {
        if (resena.getIdResena() == null) {
            resena.setIdResena(nextId++);
            resenas.add(resena);
        } else {
            deleteResena(resena.getIdResena());
            resenas.add(resena);
        }
    }

    @Override
    public void deleteResena(Long id) {
        resenas.removeIf(r -> r.getIdResena().equals(id));
    }
}
