/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.ReservaDao;
import com.desarrollowebG4.domain.Reserva;
import com.desarrollowebG4.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaServiceImpl implements ReservaService {
    
    
      @Autowired
      private ReservaDao reservadao;

    

    @Override
    public List<Reserva> findAll() {
        return reservadao.findAll();
    }

    @Override
    public Optional<Reserva> findById(Integer id) {
        return reservadao.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservadao.save(reserva);
    }

    @Override
    public void deleteById(Integer id) {
        reservadao.deleteById(id);
    }
    
}
