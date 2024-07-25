package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

// especificar que es una capa de datos
@Data
// esta clase está enlazada a una tabla en la BDD
@Entity
// especificar cuál entidad
@Table(name = "disponibilidad")
public class Disponibilidad implements Serializable {

    // auto-increment java
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidad")
    private Long idDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
