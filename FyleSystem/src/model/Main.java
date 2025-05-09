package model;

public class Main {
    public static void main(String[] args) {
        Documento raiz = new Documento("Raíz");

        Documento carpeta1 = new Documento("Carpeta1");
        Documento subcarpeta1 = new Documento("SubCarpeta1.1");
        Documento subcarpeta2 = new Documento("SubCarpeta1.2");
        Archivo archivoA = new Archivo("ArchivoA.txt");
        Archivo archivoB = new Archivo("ArchivoB.txt");

        subcarpeta1.agregarElemento(new Archivo("SubArchivo1.1.txt"));
        subcarpeta1.agregarElemento(new Archivo("SubArchivo1.2.txt"));
        subcarpeta2.agregarElemento(new Archivo("SubArchivo2.1.txt"));

        carpeta1.agregarElemento(subcarpeta1);
        carpeta1.agregarElemento(subcarpeta2);
        carpeta1.agregarElemento(archivoA);

        Documento carpeta2 = new Documento("Carpeta2");
        carpeta2.agregarElemento(archivoB);

        raiz.agregarElemento(carpeta1);
        raiz.agregarElemento(carpeta2);
        raiz.agregarElemento(new Archivo("README.md"));

        raiz.printStructured();
    }
}