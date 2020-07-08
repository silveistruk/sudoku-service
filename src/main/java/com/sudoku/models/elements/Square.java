package com.sudoku.models.elements;

public class Square {
    private Point[][] points;

    public Square(int size, int vertical, int horizontal, int[][] intPoints) {
        this.points = new Point[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                points[i][j] = new Point(size, intPoints[size * vertical + i][size * horizontal + j]);
            }
        }
    }
}
