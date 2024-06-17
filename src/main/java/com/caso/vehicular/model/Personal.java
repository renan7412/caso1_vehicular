package com.caso.vehicular.model;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class Personal {
    private String identificacion;
    private String apellidos;
    private String nombres;
    private Date fechaNacimiento;
    private String tipoSangre;
    private String cuidadNacimiento;
    private String telefono;

}
