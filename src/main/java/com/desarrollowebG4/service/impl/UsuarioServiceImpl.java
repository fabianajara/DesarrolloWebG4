package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.UsuarioDao;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Long idUsuario) {
        return usuarioDao.findByIdUsuario(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorEmail(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorTelefono(String telefono) {
        return usuarioDao.findByTelefono(telefono);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorEmailYContrasena(String email, String contrasena) {
        return usuarioDao.findByEmailAndContrasena(email, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorTelefonoYContrasena(String telefono, String contrasena) {
        return usuarioDao.findByTelefonoAndContrasena(telefono, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorEmailOTelefono(String email, String telefono) {
        return usuarioDao.findByEmailOrTelefono(email, telefono);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorEmailOTelefono(String email, String telefono) {
        return usuarioDao.existsByEmailOrTelefono(email, telefono);
    }

    @Override
    @Transactional
    public void saveUsuario(Usuario usuario, boolean crearRolUser) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void deleteUsuario(Long idUsuario) {
        usuarioDao.deleteById(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByIdUsuario(Long idUsuario) {
        return usuarioDao.findByIdUsuario(idUsuario);
    }
}
