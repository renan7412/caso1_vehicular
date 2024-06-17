package com.caso.vehicular.Enum;

import jakarta.persistence.Table;

@Table(name = "rango")
public enum GradoTipo {
    CAPITAN,
    TENIENTE,
    SUBTENIENTE,
    SARGENTO_PRIMERO,
    SARGENTO_SEGUNDO,
    CABO_PRIMERO,
    CABO_SEGUNDO;

}
