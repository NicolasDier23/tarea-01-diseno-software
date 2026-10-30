package com.mycompany.sportspredictor.model;

public abstract class Premio {
    private String descripcion;
    private int costoPuntos;

    public Premio(String descripcion, int costoPuntos) {
        this.descripcion = descripcion;
        this.costoPuntos = costoPuntos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCostoPuntos() {
        return costoPuntos;
    }

    public abstract String generarCodigoCanje();
}