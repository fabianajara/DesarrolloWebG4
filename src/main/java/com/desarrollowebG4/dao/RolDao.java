
package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol,Long>{
    
    void deleteByIdUsuario(Long idUsuario);
    
}
