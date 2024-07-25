package com.desarrollowebG4.service.impl;


import com.desarrollowebG4.dao.DisponibilidadDao;
import com.desarrollowebG4.domain.Disponibilidad;
import com.desarrollowebG4.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    @Autowired
    private DisponibilidadDao disponibilidadDao;

    @Override
    public List<Disponibilidad> listarDisponibilidades() {
        return disponibilidadDao.findAll();
    }

    @Override
    public Optional<Disponibilidad> buscarDisponibilidadPorId(Long id) {
        return disponibilidadDao.findById(id);
    }

    @Override
    public Disponibilidad guardarDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadDao.save(disponibilidad);
    }

    @Override
    public void eliminarDisponibilidad(Long id) {
        disponibilidadDao.deleteById(id);
    }
}