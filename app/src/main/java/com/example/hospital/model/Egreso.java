package com.example.hospital.model;

public class Egreso {
    private int idEgreso;
    private String observacionesEgreso, fechaRegistro, horaSalida;
    private int idPaciente;

    public Egreso(int idEgreso, String observacionesEgreso, String fechaRegistro,
                  int idPaciente, String horaSalida) {
        this.idEgreso = idEgreso;
        this.observacionesEgreso = observacionesEgreso;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.horaSalida = horaSalida;
    }

    public int getIdEgreso() { return idEgreso; }
    public String getObservacionesEgreso() { return observacionesEgreso; }
    public String getFechaRegistro() { return fechaRegistro; }
    public int getIdPaciente() { return idPaciente; }
    public String getHoraSalida() { return horaSalida; }
}