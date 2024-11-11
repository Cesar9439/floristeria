package com.iudigital.floristeria.models;

import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private Cliente cliente;
    private String tipoArreglo;
    private String ocasion;
    private String fechaEntrega;
    private double presupuesto;
    private Estado estado;
    
    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, String tipoArreglo, String ocasion, String fechaEntrega, double presupuesto, Estado estado) {
        this.id = id;
        this.cliente = cliente;
        this.tipoArreglo = tipoArreglo;
        this.ocasion = ocasion;
        this.fechaEntrega = fechaEntrega;
        this.presupuesto = presupuesto;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoArreglo() {
        return tipoArreglo;
    }

    public void setTipoArreglo(String tipoArreglo) {
        this.tipoArreglo = tipoArreglo;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
