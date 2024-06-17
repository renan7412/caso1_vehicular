package com.caso.vehicular.Service;

import com.caso.vehicular.model.Rol;
import com.caso.vehicular.model.Usuario;
import com.caso.vehicular.repository.UsuarioRepository;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
// Método para extraer una lista de autoridades por medio de sus roles
    public Collection<GrantedAuthority> mapToAuthorities(List<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
    }
// Método para encontrar un usuario mediante su nombre y extraer todos sus datos como tipo de rol, nombre, password, etc.
    /*@Override
    public UserDetails loadUserByUsername(String usuarioNombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findBynombre(usuarioNombre).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuario.getNombre(), usuario.getPassword(), mapToAuthorities(usuario.getRoles()));
    }
    */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + "username"));
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                new ArrayList<>()
        );
    }
}

