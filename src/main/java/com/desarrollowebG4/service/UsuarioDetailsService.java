package com.desarrollowebG4.service;

import com.desarrollowebG4.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
    
    Usuario findByUsername(String username);
}
