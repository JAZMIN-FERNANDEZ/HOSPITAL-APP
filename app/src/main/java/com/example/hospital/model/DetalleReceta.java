package com.example.hospital.model;

public class DetalleReceta {
    private int idReceta;
    private String medicamentoNombre, dosis, frecuencia, viaAdministracion, duracion;

    public DetalleReceta(int idReceta, String medicamentoNombre, String dosis,
                         String frecuencia, String viaAdministracion, String duracion) {
        this.idReceta = idReceta;
        this.medicamentoNombre = medicamentoNombre;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.viaAdministracion = viaAdministracion;
        this.duracion = duracion;
    }

    public int getIdReceta() { return idReceta; }
    public String getMedicamentoNombre() { return medicamentoNombre; }
    public String getDosis() { return dosis; }
    public String getFrecuencia() { return frecuencia; }
    public String getViaAdministracion() { return viaAdministracion; }
    public String getDuracion() { return duracion; }
}