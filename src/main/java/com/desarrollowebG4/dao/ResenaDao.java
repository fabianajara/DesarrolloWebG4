/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollowebG4.dao;

import com.desarrollowebG4.domain.Resena;
import com.desarrollowebG4.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenaDao extends JpaRepository<Resena, Long> {
    List<Resena> findByAlojamiento_IdAlojamiento(Long idAlojamiento);
    //List<Resena> findByUsuarioId(Long usuarioId);
    List<Resena> findByUsuario(Usuario usuario);
}

