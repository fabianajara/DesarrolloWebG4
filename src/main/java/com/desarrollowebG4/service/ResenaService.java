/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Resena;
import java.util.List;
import java.util.Optional;

public interface ResenaService {
    
   
    List<Resena> obtenerTodasLasResenas();
   

    public void guardarResena(Resena resena);

    public Optional<Resena> buscarResenaPorId(Long idResena);

    public void eliminarResena(Long idResena);
}

