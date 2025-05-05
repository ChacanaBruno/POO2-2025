package model;

public class Pasante extends Empleado {

    private int horasTrabajadas;
    private double pago;

    public Pasante() {
        super();
    }

    public Pasante(double porcentajeAportes, int horasTrabajadas, double pago) {
        super(porcentajeAportes);
        this.horasTrabajadas = horasTrabajadas;
        this.pago = pago;
    }
    @Override
    public double sueldoBruto() {
        return getPago() * getHorasTrabajadas();
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
}
