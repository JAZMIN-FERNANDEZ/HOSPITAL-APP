package com.example.hospital.model;

public class Receta {
    private int idReceta;
    private String fechaEmision, indicacionesGenerales;
    private int idConsulta;

    public Receta(int idReceta, String fechaEmision, String indicacionesGenerales, int idConsulta) {
        this.idReceta = idReceta;
        this.fechaEmision = fechaEmision;
        this.indicacionesGenerales = indicacionesGenerales;
        this.idConsulta = idConsulta;
    }

    public int getIdReceta() { return idReceta; }
    public String getFechaEmision() { return fechaEmision; }
    public String getIndicacionesGenerales() { return indicacionesGenerales; }
    public int getIdConsulta() { return idConsulta; }
}