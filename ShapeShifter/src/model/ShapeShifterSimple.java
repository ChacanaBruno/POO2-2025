package model;

import java.util.List; 

public class ShapeShifterSimple implements IShapeShifter {
    private int value;

    public ShapeShifterSimple(int value) {
        this.value = value;
    }

    @Override
    public IShapeShifter compose(IShapeShifter other) {
        ShapeShifterComposite composite = new ShapeShifterComposite();
        composite.add(this);
        composite.add(other);
        return composite;
    }

    @Override
    public int deepest() {
        return 0;
    }

    @Override
    public IShapeShifter flat() {
        return this;
    }

    @Override
    public List<Integer> values() {
        return List.of(value);
    }
}
