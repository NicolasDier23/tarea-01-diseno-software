package com.mycompany.sportspredictor.model;

import com.mycompany.sportspredictor.interfaces.IServicioNotificacion;

public class Administrador {
    private int idAdmin;

    public Administrador(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void gestionarResultado(EventoDeportivo evento, String resultado) {
        System.out.println("Administrador registrando resultado: " + resultado);
    }

    public void gestionarResultado(EventoDeportivo evento, Usuario usuario, IServicioNotificacion servicio) {
        evento.finalizarEvento();

        for (Pronostico p : usuario.getPronosticosRealizados()) {
            p.evaluarResultado();
            p.actualizarEstado("acertado");
            usuario.sumarPuntos(p.getPuntosGanados());
        }

        servicio.enviarAlerta("Resultados procesados correctamente.");
        System.out.println("Resultados gestionados con éxito por Admin.");
    }
}