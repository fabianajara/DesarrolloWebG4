package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Foto_Propiedad")
public class FotoPropiedad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long idFoto;
    
    @ManyToOne
    @JoinColumn(name = "id_propiedad")
    private Propiedad propiedad;
    
    @Column(name = "ruta_imagen")
    private String rutaImagen;
}
