package com.sudoku.models;

public class ClassicSudoku extends Sudoku {
    private static final int SIZE = 3;

    public ClassicSudoku(int[][] points) {
        super(SIZE, points);
    }
}
