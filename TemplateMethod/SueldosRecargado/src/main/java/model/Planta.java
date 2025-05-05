package model;

public class Planta extends Empleado {

    private double sueldoBasico;
    private int hijos;
    private double beneficio;

    public Planta(double porcentajeAportes ,double sueldoBasico, int hijos, double beneficio) {
        super(porcentajeAportes);
        this.sueldoBasico = sueldoBasico;
        this.hijos = hijos;
        this.beneficio = beneficio;
    }

    @Override
    public double sueldoBruto() {
        double plus = getHijos() * getBeneficio();
        return getSueldoBasico() + plus;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }
}
