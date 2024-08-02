/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Resena;
import java.util.List;

public interface ResenaServicio {
    
   
    List<Resena> obtenerTodasLasResenas();
    void guardarResena(Resena resena);
}

