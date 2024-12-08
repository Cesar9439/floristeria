package com.iudigital.floristeria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Map;

@Entity
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlor;
    private String tipoFlor;
    private String color;
    private String variedad;
    private int cantidadDisponible;
    private double precioCompra;
    private double precioVenta;


    public Flor() {

    }

    public Flor(Long idFlor, String tipoFlor, String color, String variedad, int cantidadDisponible, double precioCompra, double precioVenta) {
        this.idFlor = idFlor;
        this.tipoFlor = tipoFlor;
        this.color = color;
        this.variedad = variedad;
        this.cantidadDisponible = cantidadDisponible;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getIdFlor() {
        return idFlor;
    }

    public void setIdFlor(Long idFlor) {
        this.idFlor = idFlor;
    }

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "id=" + idFlor +
                ", tipoFlor='" + tipoFlor + '\'' +
                ", color='" + color + '\'' +
                ", variedad='" + variedad + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                '}';
    }
}

