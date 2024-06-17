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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String username;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    @Transient
    private String confirmPassword;  /* Campo  adicianal para la confirmación de contraseña (no se guarda en BD*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")) /// table de id_usuario-rol

    private List<Rol> roles = new ArrayList<>();

}

