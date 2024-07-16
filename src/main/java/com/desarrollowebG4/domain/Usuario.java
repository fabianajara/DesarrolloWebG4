package com.desarrollowebG4.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "rol_usuario")
    private String rolUsuario;
    
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    
    @Column(name = "usuario_imagen")
    private String usuarioImagen;
}
