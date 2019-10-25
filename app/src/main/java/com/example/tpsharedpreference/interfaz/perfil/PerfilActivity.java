package com.example.tpsharedpreference.interfaz.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.tpsharedpreference.R;

public class PerfilActivity extends AppCompatActivity {
    EditText etDni,etNombre,etApellido,etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        inicializar();
    }

    public void inicializar(){
        Intent intent = getIntent();

        etDni=findViewById(R.id.etDniPerfil);
        etNombre=findViewById(R.id.etNombre);
        etApellido=findViewById(R.id.etApellidoPerfil);
        etEmail = findViewById(R.id.etEmailPerfil);
        etPassword = findViewById(R.id.etPasswordPerfil);

        etDni.setText((int) intent.getLongExtra("dni",000));
        etNombre.setText(intent.getStringExtra("nombre"));
        etApellido.setText(intent.getStringExtra("apellido"));
        etEmail.setText(intent.getStringExtra("email"));
        etPassword.setText(intent.getStringExtra("password"));
    }

}
