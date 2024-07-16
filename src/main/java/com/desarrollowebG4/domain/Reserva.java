package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_propiedad")
    private Propiedad propiedad;
    
    @Column(name = "fecha_entrada")
    private Date fechaEntrada;
    
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    
    @Column(name = "num_huespedes")
    private int numHuespedes;
    
    @Column(name = "precio_total")
    private double precioTotal;
    
    private String estado;
    
    @Column(name = "fecha_reserva")
    private Timestamp fechaReserva;
}
