package com.sudoku.models.elements;

import lombok.Getter;

@Getter
public class Column extends SudokuBlock {
    private final Point[] points;

    public Column(int size, int position, Point[][] intPoints) {
        super(size);
        points = new Point[size * size];
        for (int i = 0; i < size * size; i++) {
            points[i] = intPoints[i][position];
        }
    }


    public void addDigit(int size, int[] row, int index) {
//        points[index] = new Point(size, row[index]);
        addDigit(row[index]);
    }
}
