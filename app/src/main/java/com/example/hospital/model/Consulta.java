package com.example.hospital.model;

public class Consulta {
    private int idConsulta;
    private String alergias, observacionesSintomas, diagnostico, fechaRegistro;
    private int idPaciente, idDoctor;

    public Consulta(int idConsulta, String alergias, String observacionesSintomas,
                    String diagnostico, String fechaRegistro, int idPaciente, int idDoctor) {
        this.idConsulta = idConsulta;
        this.alergias = alergias;
        this.observacionesSintomas = observacionesSintomas;
        this.diagnostico = diagnostico;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
    }

    public int getIdConsulta() { return idConsulta; }
    public String getAlergias() { return alergias; }
    public String getObservacionesSintomas() { return observacionesSintomas; }
    public String getDiagnostico() { return diagnostico; }
    public String getFechaRegistro() { return fechaRegistro; }
    public int getIdPaciente() { return idPaciente; }
    public int getIdDoctor() { return idDoctor; }
}