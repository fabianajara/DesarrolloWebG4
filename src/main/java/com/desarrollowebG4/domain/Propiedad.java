package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Propiedad")
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Long idPropiedad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String nombre;
    private String descripcion;

    @Column(name = "tipo_propiedad")
    private String tipoPropiedad;

    @Column(name = "num_habitaciones")
    private int numHabitaciones;

    @Column(name = "num_banos")
    private int numBanos;

    private int capacidad;

    @Column(name = "precio_noche")
    private double precioNoche;

    private String ubicacion;
    private double calificacion;
    private boolean disponibilidad;

    @Column(name = "propiedad_imagen")
    private String propiedadImagen;
}
