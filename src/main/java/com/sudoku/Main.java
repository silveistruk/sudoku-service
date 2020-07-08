package com.sudoku;

import com.sudoku.models.ClassicSudoku;
import com.sudoku.models.Sudoku;
import com.sudoku.models.SudokuSolver;

public class Main {

    public static void main(String[] args) {
        int[][] points = {
                {0, 0, 0, 0, 0, 7, 9, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 5, 0},
                {0, 0, 1, 2, 0, 0, 0, 0, 0},
                {1, 0, 2, 0, 8, 0, 7, 0, 0},
                {0, 0, 9, 0, 2, 3, 0, 0, 0},
                {5, 3, 0, 0, 0, 6, 2, 0, 9},
                {0, 1, 0, 0, 7, 0, 0, 0, 8},
                {0, 8, 0, 9, 0, 1, 0, 4, 0},
                {2, 5, 0, 0, 3, 0, 0, 0, 0}};
        Sudoku sudoku = new ClassicSudoku(points);
        new SudokuSolver(sudoku).solveSudoku();
    }
}
