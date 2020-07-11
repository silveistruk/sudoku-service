package com.sudoku.models.elements;

import java.util.HashSet;
import java.util.Set;

public abstract class SudokuBlock {
    protected final Set<Integer> presentDigits;

    public SudokuBlock(int size) {
        this.presentDigits = new HashSet<>(size * size, 1);
    }

    public boolean containsDigit(int digit) {
        return presentDigits.contains(digit);
    }

    protected void addDigit(int digit) {
        presentDigits.add(digit);
    }
}
