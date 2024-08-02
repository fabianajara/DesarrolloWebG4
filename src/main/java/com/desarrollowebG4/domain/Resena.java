/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import lombok.Data;

@Entity
@Table(name = "resena")
public class Resena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long idResena;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;

    @Column(nullable = false)
    private Double calificacion;

    @Column(length = 200, nullable = false)
    private String comentario;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public void setAlojamiento(Optional<Alojamiento> buscarAlojamientoPorId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setCalificacion(Double calificacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setComentario(String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
