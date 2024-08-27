package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

// especificar que es una capa de datos
@Data
// esta clase está enlazada a una tabla en la BDD
@Entity
// especificar cuál entidad
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

   @Column(name = "username")
    private String username;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "password")
    private String password;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @OneToMany(mappedBy = "usuario") // La propiedad debe coincidir con la propiedad en la entidad Rol
    private List<Rol> roles;
}

