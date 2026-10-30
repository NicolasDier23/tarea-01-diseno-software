package com.mycompany.sportspredictor.model;

import com.mycompany.sportspredictor.interfaces.IServicioNotificacion;
import com.mycompany.sportspredictor.interfaces.ITipoPronostico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private int puntosAcumulados;
    private List<Pronostico> pronosticosRealizados;

    public Usuario(int idUsuario, int puntosAcumulados) {
        this.idUsuario = idUsuario;
        this.puntosAcumulados = puntosAcumulados;
        this.pronosticosRealizados = new ArrayList<>();
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void sumarPuntos(int puntos) {
        this.puntosAcumulados += puntos;
    }

    public List<Pronostico> getPronosticosRealizados() {
        return pronosticosRealizados;
    }

    public void mostrarCalendario() {
        System.out.println("Mostrando calendario de eventos disponibles...");
    }

    public void realizarPronostico(EventoDeportivo evento, ITipoPronostico tipo) {
        Date ahora = new Date();
        if (evento.getFechaInicio().after(ahora)) {
            Pronostico nuevoPronostico = new Pronostico(evento, tipo);
            nuevoPronostico.actualizarEstado("pendiente");
            pronosticosRealizados.add(nuevoPronostico);
            System.out.println("Pronóstico registrado exitosamente (pendiente).");
        } else {
            System.out.println("Error: Evento ya iniciado. Transacción cancelada.");
        }
    }

    public boolean canjearPremio(Premio premio, IServicioNotificacion servicioNotificacion) {
        if (this.puntosAcumulados >= premio.getCostoPuntos()) {
            this.puntosAcumulados -= premio.getCostoPuntos();
            String codigo = premio.generarCodigoCanje();
            servicioNotificacion.enviarAlerta("Canje exitoso. Código: " + codigo);
            return true;
        } else {
            System.out.println("Error: Puntos insuficientes para canjear " + premio.getDescripcion());
            return false;
        }
    }
}