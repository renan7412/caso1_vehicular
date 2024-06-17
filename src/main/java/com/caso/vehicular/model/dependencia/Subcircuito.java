package com.caso.vehicular.model.dependencia;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Subcircuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "circuito")
    private Circuito circuito;
}
