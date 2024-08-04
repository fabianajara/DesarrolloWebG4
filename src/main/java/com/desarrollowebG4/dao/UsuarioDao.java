package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario,Long>{
     // Busca un usuario por su nombre de usuario.

    //Optional<Usuario> findByUsername(String username);
 
    @Override
    Optional<Usuario> findById(Long id);
   

    public Optional<Usuario> findByUsernameAndPassword(String username, String password);

    //Busca un usuario por su nombre de usuario o correo.

    Optional<Usuario> findByUsernameOrCorreo(String username, String correo);

    // Verifica si existe un usuario con el nombre de usuario o correo proporcionado.
    
    boolean existsByUsernameOrCorreo(String username, String correo);

    //Busca un usuario por su ID.
     
}   