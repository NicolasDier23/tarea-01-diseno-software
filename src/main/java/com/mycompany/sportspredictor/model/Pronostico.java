package com.mycompany.sportspredictor.model;

import com.mycompany.sportspredictor.interfaces.ITipoPronostico;

public class Pronostico {
    private String estado;
    private int puntosGanados;
    private EventoDeportivo eventoObjetivo;
    private ITipoPronostico tipoPronostico;

    public Pronostico(EventoDeportivo eventoObjetivo, ITipoPronostico tipoPronostico) {
        this.eventoObjetivo = eventoObjetivo;
        this.tipoPronostico = tipoPronostico;
        this.estado = "pendiente";
        this.puntosGanados = 0;
    }

    public String getEstado() {
        return estado;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void evaluarResultado() {
        System.out.println("Evaluando resultado del pronóstico...");
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if ("acertado".equalsIgnoreCase(nuevoEstado)) {
            this.puntosGanados = tipoPronostico.calcularPuntos();
        }
        System.out.println("Estado del pronóstico actualizado a: " + this.estado);
    }
}