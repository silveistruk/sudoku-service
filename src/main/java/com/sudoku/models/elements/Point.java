package com.sudoku.models.elements;

import java.util.HashSet;
import java.util.Set;

public class Point {
    private Integer value;
    private final Set<Integer> possibleValues;

    public Point(int size, Integer value) {
        this.value = defineValue(value);
        possibleValues = new HashSet<Integer>(size * size, 1);
    }

    private Integer defineValue(int value) {
        return value != 0 ? value : null;
    }

    public void setValue(int value) {
        possibleValues.clear();
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public int getPossibleValuesCount() {
        return possibleValues.size();
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }

    public boolean addPossibleValue(int possibleValue) {
        return possibleValues.add(possibleValue);
    }

    public boolean deletePossibleValue(int possibleValue) {
        return possibleValues.remove(possibleValue);
    }
}
