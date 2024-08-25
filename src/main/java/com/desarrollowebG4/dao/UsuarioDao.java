package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Long>{
    
    // Parte para el log in
    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);

    Usuario findByIdUsuario(Long idUsuario);
}
