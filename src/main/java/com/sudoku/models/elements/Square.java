package com.sudoku.models.elements;

import lombok.Getter;

@Getter
public class Square extends SudokuBlock {
    private final Point[][] points;

    public Square(int size, int verticalPosition, int horizontalPosition, Point[][] points) {
        super(size);
        this.points = new Point[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.points[i][j] = points[size * verticalPosition + i][size * horizontalPosition + j];
            }
        }
    }
}
