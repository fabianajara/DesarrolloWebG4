package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.AlojamientoDao;
import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

    @Autowired
    private AlojamientoDao alojamientoDao;

    @Override
    public List<Alojamiento> listarAlojamientos() {
        return alojamientoDao.findAll();
    }

    @Override
    public Optional<Alojamiento> buscarAlojamientoPorId(Long id) {
        return alojamientoDao.findById(id);
    }

    @Override
    public Alojamiento guardarAlojamiento(Alojamiento alojamiento) {
        return alojamientoDao.save(alojamiento);
    }

    @Override
    public void eliminarAlojamiento(Long id) {
        alojamientoDao.deleteById(id);
    }
}
