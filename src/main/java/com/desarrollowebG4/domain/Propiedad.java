/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

//especificar que es una capa de datos
@Data
//esta clase esa enlazada a una tabla en la bdd
@Entity
//especificar cual entidad
@Table(name = "propiedad")
public class Propiedad {
     //Autoincremento en java MySQL(Auto_INCREMENT)
      private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propiedad_id")
            
    private Long propiedadId;
    private Long propiedadUsuario;
    private String VARCHAR;
    private String descripcion;
    private String propiedad_tipo;
    private Long numHabitaciones;
    private Long numBanos;
    private Long capacidad;
    private BigDecimal precio_noche;
    private String ubicacion;
    private boolean disponibilidad;
    private BigDecimal DECIMAL;
    @Column(name = "propiedad_imagen", length = 255)       
    private String propiedadImagen;
    
}
