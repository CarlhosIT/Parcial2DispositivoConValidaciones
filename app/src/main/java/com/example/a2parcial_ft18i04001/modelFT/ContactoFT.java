package com.example.a2parcial_ft18i04001.modelFT;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contactos")
public class ContactoFT implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String numero;
    String propietario;
    public ContactoFT() {

    }

    public ContactoFT(int id, String nombre, String numero, String propietario) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
