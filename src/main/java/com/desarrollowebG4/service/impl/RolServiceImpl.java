package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.RolDao;
import com.desarrollowebG4.domain.Rol;
import com.desarrollowebG4.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    @Transactional
    public void deleteByUser(long idUsuario) {
        rolDao.deleteByIdUsuario((long) idUsuario);
    }

    
}