package com.iudigital.floristeria.models;

import java.util.List;
import java.util.Map;

public class Inventario {
    private String nombre;
    private Map<String, Integer> flores;

    public Inventario() {
    }

    public Inventario(String nombre, Map<String, Integer> flores) {
        this.nombre = nombre;
        this.flores = flores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Integer> getFlores() {
        return flores;
    }

    public void setFlores(Map<String, Integer> flores) {
        this.flores = flores;
    }
}