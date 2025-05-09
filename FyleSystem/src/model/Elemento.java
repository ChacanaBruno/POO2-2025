package model;

public abstract class Elemento {
    protected String nombre;

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void printStructured() {
        printStructured(0); // llamada inicial desde raíz
    }

    protected abstract void printStructured(int nivel); // versión interna recursiva
}