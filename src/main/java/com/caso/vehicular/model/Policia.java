package com.caso.vehicular.model;

import com.caso.vehicular.Enum.GradoTipo;
import com.caso.vehicular.model.dependencia.Subcircuito;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Data
@Entity
public class Policia extends Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private GradoTipo grado;

    @OneToOne
    @JoinColumn(name = "subcircuito_id")
    private Subcircuito subcircuito;

}
