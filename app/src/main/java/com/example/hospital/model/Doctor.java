package com.example.hospital.model;

public class Doctor {
    private int idDoctor;
    private String nombreDoctor, apellidoP, numCedula;

    public Doctor(int idDoctor, String nombreDoctor, String apellidoP, String numCedula) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.apellidoP = apellidoP;
        this.numCedula = numCedula;
    }

    public int getIdDoctor() { return idDoctor; }
    public String getNombreDoctor() { return nombreDoctor; }
    public String getApellidoP() { return apellidoP; }
    public String getNumCedula() { return numCedula; }

    public String getNombreCompleto() {
        return nombreDoctor + " " + apellidoP;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }
}