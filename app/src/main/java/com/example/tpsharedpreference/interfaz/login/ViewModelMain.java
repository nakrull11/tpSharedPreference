package com.example.tpsharedpreference.interfaz.login;

import androidx.lifecycle.ViewModel;

public class ViewModelMain extends ViewModel {

    String usuario;
    String clave;



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
