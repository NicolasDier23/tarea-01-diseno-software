package com.mycompany.sportspredictor.model;

import java.util.Date;

public class EventoDeportivo {
    private String idEvento;
    private Date fechaInicio;
    private String estado;

    public EventoDeportivo(String idEvento, Date fechaInicio, String estado) {
        this.idEvento = idEvento;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void finalizarEvento() {
        this.estado = "FINALIZADO";
        System.out.println("El evento " + idEvento + " ha finalizado.");
    }

    public void getEstadisticas() {
        System.out.println("Obteniendo estadísticas para el evento: " + idEvento);
    }
}