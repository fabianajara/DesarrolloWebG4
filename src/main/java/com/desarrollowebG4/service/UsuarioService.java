package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    // Obtiene un listado de todos los usuarios
    List<Usuario> getUsuarios();

    // Obtiene un usuario por su ID
    Usuario getUsuario(Long idUsuario);

    // Obtiene un usuario por su email
    Usuario getUsuarioPorEmail(String email);

    // Obtiene un usuario por su teléfono
    Usuario getUsuarioPorTelefono(String telefono);

    // Obtiene un usuario por su email y contraseña
    Usuario getUsuarioPorEmailYContrasena(String email, String contrasena);

    // Obtiene un usuario por su teléfono y contraseña
    Usuario getUsuarioPorTelefonoYContrasena(String telefono, String contrasena);

    // Obtiene un usuario por su email o teléfono
    Usuario getUsuarioPorEmailOTelefono(String email, String telefono);

    // Valida si existe un usuario por su email o teléfono
    boolean existeUsuarioPorEmailOTelefono(String email, String telefono);

    // Guarda un usuario (crea uno nuevo o actualiza uno existente)
    void saveUsuario(Usuario usuario, boolean crearRolUser);

    // Elimina un usuario por su ID
    void deleteUsuario(Long idUsuario);

    // Obtiene un usuario por su ID
    Usuario findByIdUsuario(Long idUsuario);
}
