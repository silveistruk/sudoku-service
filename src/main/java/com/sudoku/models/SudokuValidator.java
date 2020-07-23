package com.sudoku.models;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static void validateSudoku(int size, int[][] intPoints) {
        validateSize(size);
        checkRepeatsInRows(intPoints);
        checkRepeatsInColumns(intPoints);
        checkRepeatsInSquares(intPoints, size);
    }

    private static void validateSize(int size) {
        if (size != 3 && size != 4) {
            throw new RuntimeException("Unexpected size. It must be 3 or 4");
        }
    }

    private static void checkRepeatsInRows(int[][] intPoints) {
        Set<Integer> numbersSet = new HashSet<>(intPoints.length, 1);
        for (int[] row : intPoints) {
            numbersSet.clear();
            for (int digit : row) {
                checkRepeatedNumbers(numbersSet, digit);
            }
        }
    }

    private static void checkRepeatsInColumns(int[][] intPoints) {
        Set<Integer> numbersSet = new HashSet<>(intPoints.length, 1);
        for (int i = 0; i < intPoints.length; i++) {
            numbersSet.clear();
            for (int[] rowPoints : intPoints) {
                checkRepeatedNumbers(numbersSet, rowPoints[i]);
            }
        }
    }

    private static void checkRepeatsInSquares(int[][] intPoints, int size) {
        Set<Integer> numbersSet = new HashSet<>(intPoints.length, 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numbersSet.clear();
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        checkRepeatedNumbers(numbersSet, intPoints[i * size + k][j * size + l]);
                    }
                }
            }
        }
    }

    private static void checkRepeatedNumbers(Set<Integer> numbers, int digit) {
        if (digit != 0 && !numbers.add(digit)) {
            throw new RuntimeException("Invalid sudoku. Numbers in the row, column and square can't be repeated.");
        }
    }
}
