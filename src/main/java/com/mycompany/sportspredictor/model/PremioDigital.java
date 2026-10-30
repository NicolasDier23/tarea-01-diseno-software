package com.mycompany.sportspredictor.model;

public class PremioDigital extends Premio {
    private String codigo;

    // VS Code te pedirá que el constructor coincida con el de la clase padre (Premio)
    public PremioDigital(String descripcion, int costoPuntos, String codigo) {
        super(descripcion, costoPuntos);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Java exige sobrescribir este método de la clase padre
    @Override
    public String generarCodigoCanje() {
        return "DIGITAL-" + codigo;
    }
}