package com.example.hospital.controlador;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.hospital.model.DBHelper;

public class LoginController {
    private DBHelper dbHelper;

    public LoginController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public boolean login(String usuario, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT * FROM usuarios WHERE usuario=? AND password=?",
                new String[]{usuario, password});
        boolean valido = c.getCount() > 0;
        c.close();
        db.close();
        return valido;
    }
}