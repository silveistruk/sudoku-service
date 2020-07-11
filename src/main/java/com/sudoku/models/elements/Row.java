package com.sudoku.models.elements;

import lombok.Getter;

@Getter
public class Row extends SudokuBlock {
    private final Point[] points;

    public Row(int size, Point[] row) {
        super(size);
        points = row;
    }

    public void addDigit(int size, int[] row, int index) {
        Point point = points[index];
        addDigit(row[index]);
    }
}
