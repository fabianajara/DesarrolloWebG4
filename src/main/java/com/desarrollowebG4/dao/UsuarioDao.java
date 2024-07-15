package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByTelefono(String telefono);

    Usuario findByEmailAndContrasena(String email, String contrasena);

    Usuario findByTelefonoAndContrasena(String telefono, String contrasena);

    Usuario findByEmailOrTelefono(String email, String telefono);

    boolean existsByEmailOrTelefono(String email, String telefono);

    Usuario findByIdUsuario(Long idUsuario);
}
