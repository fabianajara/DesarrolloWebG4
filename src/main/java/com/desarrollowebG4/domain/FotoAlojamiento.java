package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "foto_alojamiento")
public class FotoAlojamiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long idFoto;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento", nullable = false)
    private Alojamiento alojamiento;

    private String rutaImagen;
    
    // Getters and setters

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
    
    

