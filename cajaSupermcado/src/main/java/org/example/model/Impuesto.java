package org.example.model;

public class Impuesto extends Factura {
    private double tasaDeServicio;

    public Impuesto() {}

    public Impuesto(Agencia agencia,double tasaDeServicio) {
        super(agencia);
        this.tasaDeServicio = tasaDeServicio;
    }

    public double getTasaDeServicio() {
        return tasaDeServicio;
    }

    @Override
    public double indicarMonto() {
        return getTasaDeServicio();
    }
}
