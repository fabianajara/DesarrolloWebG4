package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}