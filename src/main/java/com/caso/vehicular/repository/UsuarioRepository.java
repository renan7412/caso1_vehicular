package com.caso.vehicular.repository;

import com.caso.vehicular.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar a un usuario mediante su Nombre
    Optional<Usuario> findByUsername(String username);

    // Método para buscar a un usuario mediante su Email
    Optional<Usuario> findByEmail(String email);

    // Método para verificar si un usuario existe en la BD
    Boolean existsByUsername(String username);
}
