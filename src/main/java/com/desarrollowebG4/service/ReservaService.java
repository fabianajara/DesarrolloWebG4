/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Reserva;
import java.util.List;
import java.util.Optional;
    

public interface  ReservaService {
    
    List<Reserva> findAll();
    Optional<Reserva> findById(Integer id);
    Reserva save(Reserva reserva);
    void deleteById(Integer id);
    
}

