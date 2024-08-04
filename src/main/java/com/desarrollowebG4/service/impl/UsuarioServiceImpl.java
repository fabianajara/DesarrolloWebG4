package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.UsuarioDao;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.UsuarioServicio;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.desarrollowebG4.dao.RolDao;
@Service
public class UsuarioServiceImpl implements UsuarioServicio {

    private final UsuarioDao usuarioDao;
    

    // Inyección de dependencias a través del constructor
    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long idUsuario) {
        // Implementación para buscar usuario por ID
        return usuarioDao.findById(idUsuario);
    }

    @Override
    public Iterable<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Optional<Usuario> findByUsernameAndPassword(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("El nombre de usuario y la contraseña no pueden ser nulos");
        }
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<Usuario> findByUsernameOrCorreo(String username, String correo) {
        if (username == null && correo == null) {
            throw new IllegalArgumentException("El nombre de usuario y el correo no pueden ser ambos nulos");
        }
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    public boolean existsByUsernameOrCorreo(String username, String correo) {
        if (username == null && correo == null) {
            throw new IllegalArgumentException("El nombre de usuario y el correo no pueden ser ambos nulos");
        }
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }
} 

