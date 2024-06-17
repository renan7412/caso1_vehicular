package com.caso.vehicular.repository;

import com.caso.vehicular.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    // Método para buscar un Rol por su nombre en la BD
   Optional<Rol> findByName(String name);

}
