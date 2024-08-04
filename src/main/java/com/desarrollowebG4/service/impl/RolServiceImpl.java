/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.RolDao;
import com.desarrollowebG4.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
 private final RolDao rolDao;

    @Autowired
    public RolServiceImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Override
    public void eliminarPorIdUsuario(Long idUsuario) {
        if (idUsuario == null) {
            throw new IllegalArgumentException("El ID de usuario no puede ser nulo");
        }
        rolDao.deleteByUsuario_Id(idUsuario); // Asegúrate de que el nombre del método es correcto
    }
}