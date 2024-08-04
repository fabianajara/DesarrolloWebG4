/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollowebG4.controller;

import com.desarrollowebG4.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolAlojamientoController {
    @Autowired
    private RolService rolService;

    @DeleteMapping("/usuario/{idUsuario}")
    public void eliminarPorIdUsuario(@PathVariable Long idUsuario) {
        rolService.eliminarPorIdUsuario(idUsuario);
    } 
}
