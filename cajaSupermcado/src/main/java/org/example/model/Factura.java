package org.example.model;

public abstract class Factura implements Registrable{

    private double monto;

    private Agencia agenciaEjemplo;

    public Factura() {}

    public Factura (Agencia agenciaEjemplo) {
        this.monto = this.indicarMonto();
        this.agenciaEjemplo = agenciaEjemplo;
    }
    public double getMonto() {
        return monto;
    }

    public abstract double indicarMonto();

    @Override
    public void registrarse() {
        agenciaEjemplo.registrarPago(this);
    }

    public Agencia getAgenciaEjemplo() {
        return agenciaEjemplo;
    }

}
