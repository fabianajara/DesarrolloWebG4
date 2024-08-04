package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.FotoAlojamientoDao;
import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.domain.FotoAlojamiento;
import com.desarrollowebG4.service.FotoAlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoAlojamientoServiceImpl implements FotoAlojamientoService {

    private final FotoAlojamientoDao fotoAlojamientoDao;

    @Autowired
    public FotoAlojamientoServiceImpl(FotoAlojamientoDao fotoAlojamientoDao) {
        this.fotoAlojamientoDao = fotoAlojamientoDao;
    }

    @Override
    public List<FotoAlojamiento> findFotosByAlojamiento(Alojamiento alojamiento) {
        return fotoAlojamientoDao.findByAlojamiento(alojamiento);
    }
}

