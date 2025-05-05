package model;

public abstract class Empleado {

    private double porcentajeAportes;

    public Empleado() {}

    public Empleado(double porcentajeAportes) {
        this.porcentajeAportes = porcentajeAportes;
    }

    public final double sueldo() {

        double descuento = sueldoBruto() * getPorcentajeAportes(); // 13% de aportes

        return sueldoBruto() - descuento;
    }

    public abstract double sueldoBruto();

    public double getPorcentajeAportes() {
        return porcentajeAportes;
    }

    public void setPorcentajeAportes(double porcentajeAportes) {
        this.porcentajeAportes = porcentajeAportes;
    }
}