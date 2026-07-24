package com.example.hospital.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hospital.model.DBHelper;
import com.example.hospital.model.Doctor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PacienteController {
    private DBHelper dbHelper;

    public PacienteController(Context context) {
        dbHelper = new DBHelper(context);
    }

    // Guarda un nuevo paciente y regresa su id (o -1 si falla)
    public long guardarPaciente(String nombre, String apellidoP, String apellidoM,
                                String fechaNac, int edad, String genero, double peso) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String ahora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(new Date());

        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("apellidop", apellidoP);
        cv.put("apellidom", apellidoM);
        cv.put("fecha_nacimiento", fechaNac);
        cv.put("edad", edad);
        cv.put("genero", genero);
        cv.put("peso", peso);
        cv.put("fecha_hora_ingreso", ahora);
        cv.put("creado_en", ahora);

        long idPaciente = db.insert("pacientes", null, cv);
        db.close();
        return idPaciente;
    }

    // Trae todos los doctores, para llenar el Spinner del Fragment de consulta
    public List<Doctor> obtenerDoctores() {
        List<Doctor> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM doctor", null);

        if (c.moveToFirst()) {
            do {
                Doctor d = new Doctor(
                        c.getInt(c.getColumnIndexOrThrow("id_doctor")),
                        c.getString(c.getColumnIndexOrThrow("nombre_doctor")),
                        c.getString(c.getColumnIndexOrThrow("apellidop")),
                        c.getString(c.getColumnIndexOrThrow("num_cedula"))
                );
                lista.add(d);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return lista;
    }

    // Registra la consulta Y el egreso (hora de salida) juntos, para el Fragment
    public boolean registrarConsultaYEgreso(int idPaciente, int idDoctor, String alergias,
                                            String sintomas, String diagnostico, String observacionesEgreso, String horaSalida) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String ahora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(new Date());

        ContentValues cvConsulta = new ContentValues();
        cvConsulta.put("alergias", alergias);
        cvConsulta.put("observaciones_sintomas", sintomas);
        cvConsulta.put("diagnostico", diagnostico);
        cvConsulta.put("fecha_registro", ahora);
        cvConsulta.put("id_paciente", idPaciente);
        cvConsulta.put("id_doctor", idDoctor);
        long idConsulta = db.insert("consultas", null, cvConsulta);

        ContentValues cvEgreso = new ContentValues();
        cvEgreso.put("observaciones_egreso", observacionesEgreso);
        cvEgreso.put("fecha_registro", ahora);
        cvEgreso.put("id_paciente", idPaciente);
        cvEgreso.put("hora_salida", horaSalida);
        long idEgreso = db.insert("egresos", null, cvEgreso);

        db.close();
        return idConsulta != -1 && idEgreso != -1;
    }
}