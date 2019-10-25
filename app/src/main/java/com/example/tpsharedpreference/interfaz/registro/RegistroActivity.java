package com.example.tpsharedpreference.interfaz.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpsharedpreference.R;
import com.example.tpsharedpreference.api.ApiClient;
import com.example.tpsharedpreference.interfaz.login.MainActivity;
import com.example.tpsharedpreference.modelos.Usuario;

public class RegistroActivity extends AppCompatActivity {
    EditText etDni,etNombre,etApellido,etEmail,etPassword;

    Button btnRegistro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        inicializar();
    }

    public void inicializar(){
        etDni = findViewById(R.id.etDni);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEmail = findViewById(R.id.etEmailR);
        etPassword = findViewById(R.id.etPasswordR);

        btnRegistro = findViewById(R.id.btnRegistrarse);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etDni.getText().toString()!=" "&&etNombre.getText().toString()!=" "&&etApellido.getText().toString()!=" "&&
                etEmail.getText().toString()!=" "&&etPassword.getText().toString()!=" "){
                    Long dni =Long.parseLong(String.valueOf(etDni.getText()));
                    Usuario usuario = new Usuario(dni,etNombre.getText().toString(),etApellido.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString());
                    ApiClient.guardar(getApplicationContext(),usuario);
                }else Toast.makeText(getApplicationContext(),"No puede haber campos vacios",Toast.LENGTH_LONG).show();
            }
        });
    }

}
