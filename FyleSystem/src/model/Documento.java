package model;

import java.util.ArrayList;
import java.util.List;

public class Documento extends Elemento {

    private List<Elemento> elementos = new ArrayList<>();

    public Documento(String nombre) {
        super(nombre);
    }

    public void agregarElemento(Elemento e) {
        elementos.add(e);
    }

    @Override
    protected void printStructured(int nivel) {
        System.out.println("\t".repeat(nivel) + nombre);
        for (Elemento e : elementos) {
            e.printStructured(nivel + 1); // aumenta el nivel en la recursión
        }
    }
}