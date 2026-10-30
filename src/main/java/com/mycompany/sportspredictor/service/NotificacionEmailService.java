
package com.mycompany.sportspredictor.service;

import com.mycompany.sportspredictor.interfaces.IServicioNotificacion;
public class NotificacionEmailService implements IServicioNotificacion {
    @Override
    public void enviarAlerta(String mensaje) {
        System.out.println("[NOTIFICACIÓN EMAIL]: " + mensaje);
    }
}
