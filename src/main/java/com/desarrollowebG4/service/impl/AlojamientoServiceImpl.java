package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.AlojamientoDao;
import com.desarrollowebG4.domain.Alojamiento;
import com.desarrollowebG4.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class AlojamientoServiceImpl implements AlojamientoService {
//
//    @Autowired
//    private AlojamientoDao alojamientoDao;
//
//    @Override
//    public List<Alojamiento> listarAlojamientos() {
//        return alojamientoDao.findAll();
//    }
//
//    @Override
//    public Optional<Alojamiento> buscarAlojamientoPorId(Long id) {
//        return alojamientoDao.findById(id);
//    }
//
//    @Override
//    public Alojamiento guardarAlojamiento(Alojamiento alojamiento) {
//        return alojamientoDao.save(alojamiento);
//    }
//
//    @Override
//    public void eliminarAlojamiento(Long id) {
//        alojamientoDao.deleteById(id);
//    }
//}

@Service
public class AlojamientoServiceImpl implements AlojamientoService {

    @Autowired
    private AlojamientoDao alojamientoDao;

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
}
