package com.caso.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")  // Anotación para mapear el campo rolName
    private List<Usuario> usuarios = new ArrayList<>();
}
