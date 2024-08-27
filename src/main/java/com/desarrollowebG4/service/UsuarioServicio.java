/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Usuario;
import java.util.Optional;

/**
 *
 * @author code-
 */
public interface UsuarioServicio {
    
    //Busca un usuario por su ID.
     
   Optional<Usuario> buscarUsuarioPorId(Long idUsuario);

    //Obtiene todos los usuarios.

    Iterable<Usuario> obtenerTodosLosUsuarios();

    // Busca un usuario por nombre de usuario y contraseña.

    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    // Busca un usuario por nombre de usuario o correo.

    Optional<Usuario> findByUsernameOrCorreo(String username, String correo);

    //Verifica si existe un usuario con el nombre de usuario o correo proporcionado.

    boolean existsByUsernameOrCorreo(String username, String correo);
}


