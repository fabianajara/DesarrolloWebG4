/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollowebG4.service;

/**
 *
 * @author code-
 */
public interface RolService {
    /**
     * Elimina todos los roles asociados a un usuario específico.
     *
     * idUsuario El identificador del usuario cuyas asociaciones de roles se eliminarán.
     */
    public void eliminarPorIdUsuario(Long idUsuario);
   
}
