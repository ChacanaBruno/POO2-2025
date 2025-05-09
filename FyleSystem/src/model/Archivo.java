package model;

public class Archivo extends Elemento {

    public Archivo(String nombre) {
        super(nombre);
    }

    @Override
    protected void printStructured(int nivel) {
        System.out.println("\t".repeat(nivel) + nombre);
    }
}