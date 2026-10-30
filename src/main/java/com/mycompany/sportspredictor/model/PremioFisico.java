package com.mycompany.sportspredictor.model;

import java.util.UUID;

public class PremioFisico extends Premio {

    public PremioFisico(String descripcion, int costoPuntos) {
        super(descripcion, costoPuntos);
    }

    @Override
    public String generarCodigoCanje() {
        return "CANJE-FISICO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}