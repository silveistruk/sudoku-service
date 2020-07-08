package com.sudoku.models.elements;

public class Column {
    private final Point[] points;

    public Column(int size, int position, int[][] intPoints) {
        this.points = new Point[size * size];
        for (int i = 0; i < size * size; i++) {
            points[i] = new Point(size, intPoints[i][position]);
        }
    }
}
