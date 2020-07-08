package com.sudoku.models;

import com.sudoku.models.elements.Column;
import com.sudoku.models.elements.Square;
import com.sudoku.models.elements.Point;
import com.sudoku.models.elements.Row;

public abstract class Sudoku {
    protected final Point[][] points;
    protected final Row[] rows;
    protected final Column[] columns;
    protected final Square[][] squares;

    public Sudoku(int size, int[][] intPoints) {
        validateSize(size);
        int rowLength = size * size;
        this.points = new Point[rowLength][rowLength];
        this.rows = new Row[rowLength];
        this.columns = new Column[rowLength];
        this.squares = new Square[size][size];
        readySudoku(size, rowLength, intPoints);
    }

    private void readySudoku(int size, int rowLength, int[][] intPoints) {
        for (int i = 0; i < rowLength; i++) {
            rows[i] = new Row(size, intPoints[i]);
            columns[i] = new Column(size, i, intPoints);
            for (int j = 0; j < rowLength; j++) {
                points[i][j] = new Point(size, intPoints[i][j]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squares[i][j] = new Square(size, i, j, intPoints);
            }
        }
    }

    private void validateSize(int size) {
        if (size != 3 && size != 4) {
            throw new RuntimeException("Unexpected size. It must be 3 or 4");
        }
    }
}
