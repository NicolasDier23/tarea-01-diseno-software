package com.mycompany.sportspredictor;

import com.mycompany.sportspredictor.interfaces.IServicioNotificacion;
import com.mycompany.sportspredictor.interfaces.ITipoPronostico;
import com.mycompany.sportspredictor.model.*;
import com.mycompany.sportspredictor.service.NotificacionEmailService;
import java.util.Date;

public class SportsPredictor {

    public static void main(String[] args) {
        System.out.println("=== PROTOTIPO SISTEMA SPORTSPREDICTOR ===");

        // Instanciación de Servicios
        IServicioNotificacion servicioNotificacion = new NotificacionEmailService();

        // Instanciación de Entidades
        Usuario usuario = new Usuario(1, 100);
        Administrador admin = new Administrador(101);

        // Fecha futura para simular evento pendiente
        Date fechaFutura = new Date(System.currentTimeMillis() + 86400000);
        EventoDeportivo evento = new EventoDeportivo("EVT-001", fechaFutura, "PROGRAMADO");

        ITipoPronostico tipoPronostico = new MarcadorExacto("2-1");
        Premio premio = new PremioFisico("Camiseta Oficial", 50);

        // --- Secuencia 1: Realizar Pronóstico ---
        System.out.println("\n--- Secuencia 1: Realizar Pronóstico ---");
        usuario.mostrarCalendario();
        evento.getEstadisticas();
        usuario.realizarPronostico(evento, tipoPronostico);

        // --- Secuencia 2: Canjear Premios ---
        System.out.println("\n--- Secuencia 2: Canjear Premios ---");
        usuario.canjearPremio(premio, servicioNotificacion);

        // --- Secuencia 3: Gestionar Resultados ---
        System.out.println("\n--- Secuencia 3: Gestionar Resultados ---");
        admin.gestionarResultado(evento, usuario, servicioNotificacion);

        System.out.println("\nPuntos finales del usuario: " + usuario.getPuntosAcumulados());
    }
}