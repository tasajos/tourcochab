package org.tourcocha.chakuy.model;

public class EmergModel {

    String Nombre,Telefono,Tipo,Whatsapp;

    public   EmergModel (){}


    public EmergModel(String nombre, String telefono, String tipo, String whatsapp) {
        Nombre = nombre;
        Telefono = telefono;
        Tipo = tipo;
        Whatsapp = whatsapp;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getWhatsapp() {
        return Whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        Whatsapp = whatsapp;
    }
}
