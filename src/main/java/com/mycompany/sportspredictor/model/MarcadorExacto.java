package com.mycompany.sportspredictor.model;

import com.mycompany.sportspredictor.interfaces.ITipoPronostico;

public class MarcadorExacto implements ITipoPronostico {
    private String marcadorPronosticado;

    public MarcadorExacto(String marcadorPronosticado) {
        this.marcadorPronosticado = marcadorPronosticado;
    }

    @Override
    public int calcularPuntos() {
        return 15;
    }
}