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
    private Usuario anfitrion; 

    private String nombre;
    private String descripcion;
    private String alojamientoTipo;
    private int numHabitaciones;
    private int numBanos;
    private int capacidad;
    private double precioNoche;
    private String ubicacion;
    private double calificacion;
    private String rutaImagen;
    private boolean activo;
    
    // Fotos extra del alojamiento
    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FotoAlojamiento> fotos;

}
