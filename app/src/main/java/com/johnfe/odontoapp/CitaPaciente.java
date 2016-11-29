package com.johnfe.odontoapp;

import java.util.List;

/**
 * Created by Johnfe Vargas on 2016-11-28.
 */

public class CitaPaciente {

    private String cedulaPaciente;
    private String fechaCita;
    private String nombreAcudiente;
    private String cedulaAcudiente;
    private String telfonoAcudiente;
    private String motivoConsulta;
    private String parentescoAcudiente;
    private List<Diente> diagnosticoDientes;


    public String getParentescoAcudiente() {
        return parentescoAcudiente;
    }

    public void setParentescoAcudiente(String parentescoAcudiente) {
        this.parentescoAcudiente = parentescoAcudiente;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getCedulaAcudiente() {
        return cedulaAcudiente;
    }

    public void setCedulaAcudiente(String cedulaAcudiente) {
        this.cedulaAcudiente = cedulaAcudiente;
    }

    public String getTelfonoAcudiente() {
        return telfonoAcudiente;
    }

    public void setTelfonoAcudiente(String telfonoAcudiente) {
        this.telfonoAcudiente = telfonoAcudiente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public List<Diente> getDiagnosticoDientes() {
        return diagnosticoDientes;
    }

    public void setDiagnosticoDientes(List<Diente> diagnosticoDientes) {
        this.diagnosticoDientes = diagnosticoDientes;
    }



}
