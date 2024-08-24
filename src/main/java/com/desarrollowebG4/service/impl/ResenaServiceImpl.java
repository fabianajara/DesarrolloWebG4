/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.ResenaDao;
import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.ResenaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaServiceImpl implements ResenaService{
    
   private final ResenaDao resenaDao;

    @Autowired
    public ResenaServiceImpl(ResenaDao resenaDao) {
        this.resenaDao = resenaDao;
    }

    @Override
    public List<Resena> obtenerTodasLasResenas() {
        return resenaDao.findAll();
    }

    @Override
    public void guardarResena(Resena resena) {
        if (resena == null) {
            throw new IllegalArgumentException("La reseña no puede ser nula");
        }
        resenaDao.save(resena);
    }

    @Override
    public Optional<Resena> buscarResenaPorId(Long idResena) {
        if (idResena == null) {
            throw new IllegalArgumentException("El ID de la reseña no puede ser nulo");
        }
        return resenaDao.findById(idResena);
    }

    @Override
    public void eliminarResena(Long idResena) {
        if (idResena == null) {
            throw new IllegalArgumentException("El ID de la reseña no puede ser nulo");
        }
        resenaDao.deleteById(idResena);
    }
}
