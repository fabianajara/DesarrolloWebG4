
package com.desarrollowebG4.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

//especificar que es una capa de datos
@Data
//esta clase esa enlazada a una tabla en la bdd
@Entity
//especificar cual entidad
@Table(name = "usuario")

public class Usuario implements Serializable {
    //Autoincremento en java MySQL(Auto_INCREMENT)
      private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    
    private Long usuarioId;
    private String usuarioTipo;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    @Column(name = "usuario_id", length = 255)
    private String usuarioImagen;
    
    public Usuario(){
    }
    
    public Usuario(String usuarioTipo, String nombre, String email, String telefono){
        this.usuarioTipo = usuario;
        this.nombre = usuario;
        this.email = usuario;
        this.telefono = usuario;
   
        
    }
}
