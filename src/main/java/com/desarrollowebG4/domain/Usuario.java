
package com.desarrollowebG4.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.Column;

@Data
//esta clase esa enlazada a una tabla en la bdd
@Entity
//especificar cual entidad
@Table(name="usuario")
public class Usuario implements Serializable {
//Realiza un autoincremento en java MYSQL(AUTO_INCREMENT)
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//valor del Id
@Column(name = "usuario_id")//Que sea un mismo valor
  
    //Variables de la baser 
    private Long usuarioId;
    private String usuarioTipo;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private String usuarioImagen;
    //@Column(name = "usuario_id", length = 255)
    
  //Para hacer filtros
    public Usuario (String usuario, String nombre, String email,String contrasena,String telefono){
      this.usuarioTipo = usuario;
      this.nombre = usuario;
      this.email = usuario;
      this.contrasena = usuario;
      this.telefono = usuario;
    }
 }
