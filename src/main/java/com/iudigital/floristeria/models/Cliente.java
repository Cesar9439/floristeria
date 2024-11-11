package com.iudigital.floristeria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String direccion;
    private String contacto;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String direccion, String contacto) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Long getId() {
        return idCliente;
    }

    public void setId(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
