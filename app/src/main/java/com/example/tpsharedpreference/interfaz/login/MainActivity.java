package com.example.tpsharedpreference.interfaz.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpsharedpreference.R;
import com.example.tpsharedpreference.api.ApiClient;
import com.example.tpsharedpreference.interfaz.registro.RegistroActivity;
import com.example.tpsharedpreference.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button btnLogin;
    Button btnRegistro;
    ViewModelMain viewModelMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        registroView();
    }

    public void inicializar(){
        viewModelMain = ViewModelProviders.of(this).get(ViewModelMain.class);
        email = findViewById(R.id.etEmail);
        password= findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        viewModelMain.setClave(password.getText().toString());
        viewModelMain.setUsuario(email.getText().toString());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Usuario usuario=ApiClient.login(getApplicationContext(),email.toString(),password.toString());
                    if (usuario!=null){
                    Intent intent = new Intent("com.example.tpsharedpreference.interfaz.perfil;");
                    intent.putExtra("dni",usuario.getDni());
                    intent.putExtra("nombre",usuario.getNombre());
                    intent.putExtra("apellido",usuario.getApellido());
                    intent.putExtra("email",usuario.getEmail());
                    intent.putExtra("password",usuario.getPassword());
                    startActivity(intent);}else Toast.makeText(getApplicationContext(),"Error al logearse",Toast.LENGTH_LONG).show();

                }catch (Exception ex){
                    ex.getMessage();
                }
            }
        });
    }

    public void registroView(){
        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
            }
        });
    }
}
