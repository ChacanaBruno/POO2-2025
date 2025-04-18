package org.example.model;

public class ProductoEmpresa implements Registrable {
    private double precio;
    private int stock;
    private String nombre;

    public ProductoEmpresa(double precio, int stock, String nombre) {
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void disminuirStock() {
        if (getStock() > 0) {
            setStock(getStock() - 1 );
        }
    }


    @Override
    public double registrarse() {
        if (getStock() > 0) {
            this.disminuirStock();
            return getPrecio();
        }
        return 0.0;
    }
}
