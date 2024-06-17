package com.caso.vehicular.model;

import com.caso.vehicular.Enum.TipoVehiculo;
import com.caso.vehicular.model.dependencia.Subcircuito;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String chasis;
    private String marca;
    private String modelo;
    private String motor;
    private double kilometraje;
    private String cilindraje;
    private double capacidadCarga;
    private int capacidadPasajeros;

    private boolean disponible;
    private TipoVehiculo tipo;

    /*@OneToMany
    @Column(name = "mantenimiento_id")
    private List<SolicitudMantenimiento> mantenimientos;*/

    @OneToOne
    @JoinColumn(name = "subcircuito_id")
    private Subcircuito subcircuito;
}
