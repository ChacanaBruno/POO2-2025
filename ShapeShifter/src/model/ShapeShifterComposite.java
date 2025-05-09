package model;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterComposite implements IShapeShifter {
    private List<IShapeShifter> children = new ArrayList<>();

    public void add(IShapeShifter shifter) {
        children.add(shifter);
    }

    @Override
    public IShapeShifter compose(IShapeShifter other) {
        ShapeShifterComposite composite = new ShapeShifterComposite(); // crea un nuevo nodo compuesto vacío
        composite.add(this);   // agrega el nodo actual (this) como hijo
        composite.add(other);  // agrega el otro nodo recibido como parámetro
        return composite;      // retorna el nuevo compuesto
    }


    /**
     * Calcula la profundidad máxima del árbol de ShapeShifter.
     * 
     * La profundidad se define como la cantidad de niveles anidados de ShapeShifter,
     * siendo los objetos simples (hojas) de profundidad 0.
     * Este método suma 1 por el nivel actual y recorre todos sus hijos para encontrar
     * la mayor profundidad entre ellos.
     * 
     * @return la profundidad máxima del árbol a partir de este nodo.
     */
    @Override
    public int deepest() {
        int maxProfundidad = 0; // variable para guardar la mayor profundidad encontrada

        // Recorre todos los hijos del nodo actual
        for (IShapeShifter child : children) {
            int profundidadHijo = child.deepest(); // obtiene la profundidad del hijo

            // Actualiza si encuentra una mayor profundidad
            if (profundidadHijo > maxProfundidad) {
                maxProfundidad = profundidadHijo;
            }
        }

        // Suma 1 por el nivel actual y retorna la profundidad total
        return 1 + maxProfundidad;
    }


    @Override
    public IShapeShifter flat() {
        ShapeShifterComposite flatComposite = new ShapeShifterComposite(); // nuevo compuesto plano

        for (IShapeShifter child : children) {                  // recorre los hijos
            for (Integer val : child.values()) {                // obtiene todos sus valores
                flatComposite.add(new ShapeShifterSimple(val)); // crea un nodo simple por cada valor
            }
        }

        return flatComposite; // retorna el nuevo árbol plano
    }


    @Override
    public List<Integer> values() {
        List<Integer> result = new ArrayList<>();

        for (IShapeShifter child : children) {       // recorre los hijos
            result.addAll(child.values());           // agrega todos los valores recursivamente
        }

        return result; // retorna la lista de enteros
    }

}
