/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer id_reserva;

    private Integer id_usuario;
    private Integer id_alojamiento;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Integer num_huespedes;
    private Double precio_total;
    private String estado;
    private Date fecha_reserva;

  

}
