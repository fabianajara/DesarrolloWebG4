package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

// especificar que es una capa de datos
@Data
// esta clase está enlazada a una tabla en la BDD
@Entity
// especificar cuál entidad
@Table(name = "alojamiento")
public class Alojamiento implements Serializable {

    // auto-increment java
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alojamiento")
    private Long idAlojamiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "alojamiento_tipo")
    private String alojamientoTipo;

    @Column(name = "num_habitaciones")
    private Integer numHabitaciones;

    @Column(name = "num_banos")
    private Integer numBanos;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "precio_noche")
    private Double precioNoche;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "calificacion")
    private Double calificacion;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "activo")
    private Boolean activo;

}