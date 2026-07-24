package com.example.hospital.model;

public class Paciente {
    private int idPaciente;
    private String nombre, apellidoP, apellidoM, genero;
    private int edad;
    private double peso;

    public Paciente(int idPaciente, String nombre, String apellidoP,
                    String apellidoM, int edad, String genero, double peso) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
    }

    public int getIdPaciente() { return idPaciente; }
    public String getNombre() { return nombre; }
    public String getApellidoP() { return apellidoP; }
    public String getApellidoM() { return apellidoM; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public double getPeso() { return peso; }

    public String getNombreCompleto() {
        return nombre + " " + apellidoP + " " + apellidoM;
    }
}