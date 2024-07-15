/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

//especificar que es una capa de datos
@Data
//esta clase esa enlazada a una tabla en la bdd
@Entity
//especificar cual entidad
@Table(name = "reserva")
public class Reserva {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
                
    private Long idReserva;
    private Long idPropiedad;
    @Column(name = "fecha_entradaa")
    private LocalDate fechaEntrada;
    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;
    private Long numHuéspedes;
    private BigDecimal precio_total;
    private String estado;
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;
    
}
