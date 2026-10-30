package com.mycompany.sportspredictor.model;

import com.mycompany.sportspredictor.interfaces.ITipoPronostico;

public class ResultadoPartido implements ITipoPronostico {
    @Override
    public int calcularPuntos() {
        return 10;
    }
}