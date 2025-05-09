package model;


public class Main {
    public static void main(String[] args) {
        // Creamos Shapeshifters simples con valores individuales
        IShapeShifter a = new ShapeShifterSimple(1);
        IShapeShifter b = new ShapeShifterSimple(2);
        IShapeShifter c = new ShapeShifterSimple(3);

        // Composición: a.compose(b) → crea un Composite con [a, b]
        IShapeShifter ab = a.compose(b);

        // Composición anidada: d = c.compose(ab)
        IShapeShifter d = c.compose(ab);

        // Probamos deepest()
        System.out.println("Profundidad de a: " + a.deepest());     // 0
        System.out.println("Profundidad de ab: " + ab.deepest());   // 1
        System.out.println("Profundidad de d: " + d.deepest());     // 2

        // Probamos values()
        System.out.println("Valores de a: " + a.values());          // [1]
        System.out.println("Valores de ab: " + ab.values());        // [1, 2]
        System.out.println("Valores de d: " + d.values());          // [3, 1, 2]

        // Probamos flat()
        IShapeShifter flatD = d.flat();
        System.out.println("Flat de d: " + flatD.values());         // [3, 1, 2]
        System.out.println("Profundidad de flat(d): " + flatD.deepest()); // 1
    }
}
