package com.sudoku.models.elements;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Point {
    private Integer value;
    private final Set<Integer> possibleValues;

    public Point(int size, Integer value) {
        this.value = defineValue(value);
        possibleValues = new HashSet<>(size * size, 1);
    }

    public void setValue(int value) {
        possibleValues.clear();
        this.value = value;
    }

    public int getPossibleValuesCount() {
        return possibleValues.size();
    }

    public boolean addPossibleValue(int possibleValue) {
        return possibleValues.add(possibleValue);
    }

    public boolean deletePossibleValue(int possibleValue) {
        return possibleValues.remove(possibleValue);
    }

    private Integer defineValue(int value) {
        return value != 0 ? value : null;
    }
}
