/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.ResenaDao;
import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.service.ResenaServicio;
import org.springframework.beans.factory.annotation.Autowired;


public class ResenaServiceImpl implements ResenaServicio{
    
    @Autowired
    private ResenaDao resenaDao;

    @Override
    public List<Resena> obtenerTodasLasResenas() {
        return resenaDao.findAll();
    }

    @Override
    public void guardarReseña(Resena resena) {
        resenaDao.save(resena);
    }
}
