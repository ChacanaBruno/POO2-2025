package model;

public class Main {
    public static void main(String[] args) {
        Documento raiz = new Documento("Raíz");
        Documento carpeta1 = new Documento("Carpeta1");
        Documento carpeta2 = new Documento("Carpeta2");
        Archivo archivoA = new Archivo("ArchivoA.txt");
        Archivo archivoB = new Archivo("ArchivoB.txt");

        carpeta1.agregarElemento(archivoA);
        carpeta2.agregarElemento(archivoB);
        raiz.agregarElemento(carpeta1);
        raiz.agregarElemento(carpeta2);

        raiz.printStructured(); // llamada externa sin nivel
    }
}