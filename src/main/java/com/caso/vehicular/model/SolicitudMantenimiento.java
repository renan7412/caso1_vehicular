package com.caso.vehicular.model;

import com.caso.vehicular.Enum.TipoMantenimientoPC;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
@Table(name = "Solicitud_mantenimiento")
public class SolicitudMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoMantenimientoPC tipoMantenimientoPC;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToOne
    @JoinColumn(name = "policia_id")
    private Policia policia;

    @OneToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    private String observaciones;
}
