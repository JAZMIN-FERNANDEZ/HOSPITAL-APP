package com.example.hospital.vista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hospital.R;
import com.example.hospital.controlador.LoginController;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtPassword;
    private Button btnIngresar;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        loginController = new LoginController(this);

        btnIngresar.setOnClickListener(v -> {
            String usuario = edtUsuario.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (loginController.login(usuario, password)) {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}