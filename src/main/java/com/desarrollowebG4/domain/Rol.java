package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // Es la clave foránea en la tabla Rol
    private Usuario usuario;

  
}
