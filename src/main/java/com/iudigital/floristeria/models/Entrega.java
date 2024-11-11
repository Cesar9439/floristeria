package com.iudigital.floristeria.models;

import jakarta.persistence.*;

@Entity
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConductor;
    private String nombre;
    private String ruta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

    public Entrega() {
    }

    public Entrega(Long idConductor, String nombre, String ruta, Pedido pedido) {
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.ruta = ruta;
        this.pedido = pedido;
    }

    public Long getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Long idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
