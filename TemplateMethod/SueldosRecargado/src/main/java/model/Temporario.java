package model;

public class Temporario extends Planta {

    private int horasTrabajadas;
    private boolean casado;

    public Temporario(double porcentajeAportes,double sueldoBasico, int hijos, double beneficio, int horasTrabajadas, boolean casado) {
        super(porcentajeAportes, sueldoBasico, hijos, beneficio);
        this.horasTrabajadas = horasTrabajadas;
        this.casado = casado;
    }

    @Override
    public double sueldoBruto() {
        double montoPorHora = getHorasTrabajadas() * 5;

        if(isCasado() || getHijos() > 0) {

            double sueldoBruto = getSueldoBasico() + montoPorHora + getBeneficio();

            return sueldoBruto;
        }
        double sueldoBruto = getSueldoBasico() + montoPorHora;

        return sueldoBruto;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}
