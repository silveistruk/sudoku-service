package com.sudoku.models.elements;

public class Row {
    private final Point[] points;

    public Row(int size, int[] row) {
        points = new Point[size * size];
        for (int i = 0; i < row.length; i++) {
            points[i] = new Point(size, row[i] != 0 ? row[i] : null);
            for (;;) {

            }
        }
    }
}
