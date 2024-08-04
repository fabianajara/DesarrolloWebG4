
package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol,Long>{
    
  // Método para eliminar roles por ID de usuario public void deleteByUsuarioId(Long idRol);
  
    public void deleteByUsuario_Id(Long idUsuario);
    
}
