package com.example.hospital.model;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "hospital.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "usuario TEXT NOT NULL, password TEXT NOT NULL)");

        db.execSQL("CREATE TABLE pacientes (" +
                "id_paciente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, apellidop TEXT NOT NULL, apellidom TEXT NOT NULL, " +
                "fecha_nacimiento TEXT NOT NULL, edad INTEGER NOT NULL, genero TEXT NOT NULL, " +
                "peso REAL NOT NULL, fecha_hora_ingreso TEXT NOT NULL, creado_en TEXT NOT NULL)");

        db.execSQL("CREATE TABLE doctor (" +
                "id_doctor INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre_doctor TEXT NOT NULL, apellidop TEXT NOT NULL, num_cedula TEXT NOT NULL)");

        db.execSQL("CREATE TABLE consultas (" +
                "id_consulta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "alergias TEXT NOT NULL, observaciones_sintomas TEXT NOT NULL, " +
                "diagnostico TEXT NOT NULL, fecha_registro TEXT NOT NULL, " +
                "id_paciente INTEGER NOT NULL, id_doctor INTEGER NOT NULL, " +
                "FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente), " +
                "FOREIGN KEY(id_doctor) REFERENCES doctor(id_doctor))");

        db.execSQL("CREATE TABLE egresos (" +
                "id_egreso INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "observaciones_egreso TEXT NOT NULL, fecha_registro TEXT NOT NULL, " +
                "id_paciente INTEGER NOT NULL, hora_salida TEXT NOT NULL, " +
                "FOREIGN KEY(id_paciente) REFERENCES pacientes(id_paciente))");

        db.execSQL("CREATE TABLE recetas (" +
                "id_receta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha_emision TEXT NOT NULL, indicaciones_generales TEXT NOT NULL, " +
                "id_consulta INTEGER NOT NULL, " +
                "FOREIGN KEY(id_consulta) REFERENCES consultas(id_consulta))");

        db.execSQL("CREATE TABLE detalle_receta (" +
                "id_receta INTEGER PRIMARY KEY, " +
                "medicamento_nombre TEXT NOT NULL, dosis TEXT NOT NULL, " +
                "frecuencia TEXT NOT NULL, via_administracion TEXT NOT NULL, duracion TEXT, " +
                "FOREIGN KEY(id_receta) REFERENCES recetas(id_receta))");

        precargarDatos(db);
    }

    private void precargarDatos(SQLiteDatabase db) {
        db.execSQL("INSERT INTO usuarios (usuario, password) VALUES ('admin','1234')");
        db.execSQL("INSERT INTO usuarios (usuario, password) VALUES ('doctor1','clave1')");

        db.execSQL("INSERT INTO doctor (nombre_doctor, apellidop, num_cedula) VALUES " +
                "('Ana','Pérez','DOC001'),('Luis','López','DOC002')," +
                "('María','Gómez','DOC003'),('Carlos','Ruiz','DOC004')");

        db.execSQL("INSERT INTO pacientes (nombre, apellidop, apellidom, fecha_nacimiento, " +
                "edad, genero, peso, fecha_hora_ingreso, creado_en) VALUES " +
                "('Juan','Torres','Díaz','1990-05-12',35,'M',72.5,'2026-07-20 09:00:00','2026-07-20 09:00:00')," +
                "('Sofía','Ramírez','León','2001-02-03',24,'F',58.0,'2026-07-20 10:15:00','2026-07-20 10:15:00')," +
                "('Pedro','Salas','Núñez','1985-11-30',40,'M',80.2,'2026-07-21 08:30:00','2026-07-21 08:30:00')," +
                "('Laura','Ibarra','Cruz','1998-07-19',27,'F',65.4,'2026-07-21 11:00:00','2026-07-21 11:00:00')");

        db.execSQL("INSERT INTO consultas (alergias, observaciones_sintomas, diagnostico, " +
                "fecha_registro, id_paciente, id_doctor) VALUES " +
                "('Ninguna','Dolor de cabeza','Migraña','2026-07-20 09:10:00',1,1)," +
                "('Penicilina','Fiebre y tos','Gripe','2026-07-20 10:20:00',2,2)," +
                "('Ninguna','Dolor abdominal','Gastritis','2026-07-21 08:40:00',3,3)," +
                "('Polvo','Comezón en piel','Dermatitis','2026-07-21 11:05:00',4,4)");

        db.execSQL("INSERT INTO egresos (observaciones_egreso, fecha_registro, id_paciente, hora_salida) VALUES " +
                "('Alta médica','2026-07-20 11:00:00',1,'11:00:00')," +
                "('Alta médica','2026-07-20 12:30:00',2,'12:30:00')," +
                "('Alta médica','2026-07-21 09:50:00',3,'09:50:00')," +
                "('Alta médica','2026-07-21 12:00:00',4,'12:00:00')");

        db.execSQL("INSERT INTO recetas (fecha_emision, indicaciones_generales, id_consulta) VALUES " +
                "('2026-07-20 09:15:00','Reposo y tomar abundante agua',1)," +
                "('2026-07-20 10:25:00','Reposo por 3 días',2)," +
                "('2026-07-21 08:45:00','Dieta blanda',3)," +
                "('2026-07-21 11:10:00','Evitar contacto con polvo',4)");

        db.execSQL("INSERT INTO detalle_receta (id_receta, medicamento_nombre, dosis, frecuencia, " +
                "via_administracion, duracion) VALUES " +
                "(1,'Paracetamol','500mg','Cada 8 horas','Oral','3 días')," +
                "(2,'Ibuprofeno','400mg','Cada 12 horas','Oral','5 días')," +
                "(3,'Omeprazol','20mg','Cada 24 horas','Oral','7 días')," +
                "(4,'Loratadina','10mg','Cada 24 horas','Oral','5 días')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS detalle_receta");
        db.execSQL("DROP TABLE IF EXISTS recetas");
        db.execSQL("DROP TABLE IF EXISTS egresos");
        db.execSQL("DROP TABLE IF EXISTS consultas");
        db.execSQL("DROP TABLE IF EXISTS doctor");
        db.execSQL("DROP TABLE IF EXISTS pacientes");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}