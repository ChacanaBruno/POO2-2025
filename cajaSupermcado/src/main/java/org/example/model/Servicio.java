package org.example.model;

public class Servicio extends Factura {
    private double costoPorUnidad;
    private double cantidadConsumida;

    public Servicio(Agencia agenciaEjemplo, double costoPorUnidad, double cantidadConsumida) {
            super(agenciaEjemplo);
        this.costoPorUnidad = costoPorUnidad;
        this.cantidadConsumida = cantidadConsumida;
    }

    public  double getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public  double getCantidadConsumida() {
        return cantidadConsumida;
    }

    @Override
    public double indicarMonto() {
        return getCostoPorUnidad() * getCantidadConsumida();
    }
}
