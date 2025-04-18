package org.example.model;

public class ProductoCooperativa extends ProductoEmpresa {
    private double descuento;

    public ProductoCooperativa(double precio, int stock, String nombre, double descuento) {
        super(precio, stock, nombre);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public double precioConDescuento() {
        return getPrecio() - (getPrecio() * getDescuento());
    }

    @Override
    public double registrarse() {
        if (getStock() > 0) {
            this.disminuirStock();
            return this.precioConDescuento();
        }
        return 0.0;
    }
}
