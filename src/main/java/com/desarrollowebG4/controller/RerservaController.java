/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.controller;

import com.desarrollowebG4.domain.Reserva;
import com.desarrollowebG4.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public class RerservaController {
    
     @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> getReservaById(@PathVariable Integer id) {
        return reservaService.findById(id);
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }


    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Integer id) {
        reservaService.deleteById(id);
    }
}


