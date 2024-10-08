package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.AlojamientoDao;
import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

    @Autowired
    private AlojamientoDao alojamientoDao;

    // Parte para el CRUD
    @Override
    @Transactional(readOnly = true)
    public List<Alojamiento> getAlojamientos(boolean activos) {
        var lista = alojamientoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    public List<Alojamiento> findByAnfitrionUsername(String username) {
        return alojamientoDao.findByAnfitrionUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Alojamiento getAlojamiento(Alojamiento alojamiento) {
        return alojamientoDao.findById(alojamiento.getIdAlojamiento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Alojamiento alojamiento) {
        alojamientoDao.save(alojamiento); // Modificar el ID (alojamiento)
    }

    @Override
    @Transactional
    public void delete(Alojamiento alojamiento) {
        alojamientoDao.delete(alojamiento); // Eliminar el ID (alojamiento)
    }
    
    @Override
    public Optional<Alojamiento> buscarAlojamientoPorId(Long id) {
        return alojamientoDao.findById(id);
    }
    
    // Parte par a los filtros de busqueda
    @Override
    public List<Alojamiento> filtrarAlojamientos(Double precioInf, Double precioSup, String ubicacion, Integer capacidad) {
        // Llamamos al método del repositorio que realiza la consulta con filtros opcionales
        return alojamientoDao.filtrarAlojamientos(precioInf, precioSup, ubicacion, capacidad);
    }
}
