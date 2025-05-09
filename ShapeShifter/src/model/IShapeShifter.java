package model;

import java.util.List;

public interface IShapeShifter {
    IShapeShifter compose(IShapeShifter other);
    int deepest();
    IShapeShifter flat();
    List<Integer> values();
}