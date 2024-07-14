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
@Table(name = "fotoPropiedad")
public class FotoPropiedad {
    //Autoincremento en java MySQL(Auto_INCREMENT)
      private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foto_id")
    
    private Long fotoId;
    private Long propiedad_id;
    private String rutaImagen;
}
