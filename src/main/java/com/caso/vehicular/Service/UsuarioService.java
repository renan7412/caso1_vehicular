package com.caso.vehicular.Service;

import com.caso.vehicular.model.Usuario;
import com.caso.vehicular.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

// Se puede obtener una lista de autoridades y roles:
    @Autowired
    private UsuarioRepository usuarioRepository;
//UserDetailService para encontrar un usuario mediante su nombre y extraer todos sus datos como tipo de rol, nombre, password, etc.
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void registrar(Long id) {
    usuarioRepository.deleteById(id);
    }

    public boolean verificarEmailPassword(Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            Usuario foundUsuario = optionalUsuario.get();
            return passwordEncoder.matches(usuario.getPassword(), foundUsuario.getPassword());
        }
        return false;
    }

    public static boolean findByUsername(String username) {
        return true;
    }
}
