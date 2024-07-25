package com.desarrollowebG4.service.impl;

import com.desarrollowebG4.dao.UsuarioDao;
import com.desarrollowebG4.domain.Rol;
import com.desarrollowebG4.domain.Usuario;
import com.desarrollowebG4.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
        implements UsuarioDetailsService, 
        UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario==null){
            //no encontro
            throw new UsernameNotFoundException(username);
            
        }
        //si estoy acá si encot´ro el usuario
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //tambien guardo en eseion el idUsuario
        session.removeAttribute("idUsuario");
        session.setAttribute("idUsuario", usuario.getIdUsuario());
        
//        System.out.println("papasfritas" + usuario.getIdUsuario());
        
        
        //se recuperan los role ddel usuario y se transforman 
        //en roles de seguridad del sistema
        var roles= new ArrayList<GrantedAuthority>();
        for(Rol r : usuario.getRoles()){
            //se agregan los roles como permisos o loles reales
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
            
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
}