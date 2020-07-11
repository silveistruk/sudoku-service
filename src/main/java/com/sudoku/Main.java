package com.sudoku;

import com.sudoku.models.ClassicSudoku;
import com.sudoku.models.Sudoku;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        InputSudokuModel inputSudokuModel = main.getInputSudokuModel();
        int[][] points = main.getArraySudoku(inputSudokuModel);
        Sudoku sudoku = new ClassicSudoku(points);
        new SudokuSolver(sudoku).solveSudoku();
    }

    private InputSudokuModel getInputSudokuModel() {
        int size = 3;
        String inputSudokuData = "0 0 1 0 3 4 0 0 6\n" +
                "0 4 0 0 0 2 5 8 0\n" +
                "0 5 0 1 8 0 0 4 0\n" +
                "1 3 2 0 4 0 0 0 0\n" +
                "0 0 0 0 1 6 0 0 0\n" +
                "7 6 4 8 5 0 0 2 0\n" +
                "0 0 0 3 9 1 0 5 8\n" +
                "9 1 0 7 0 8 4 0 0\n" +
                "6 0 0 4 2 0 0 0 7";
        return InputSudokuModel.builder()
                .size(size)
                .inputSudoku(inputSudokuData)
                .build();
    }

    private int[][] getArraySudoku(InputSudokuModel inputSudokuModel) {
        validateSudokuElements(inputSudokuModel.getInputSudoku());

        String[] sudokuRows = inputSudokuModel.getInputSudoku().split("\n");
        int rowLength = inputSudokuModel.getSize() * inputSudokuModel.getSize();

        validateSudokuElementsLength(rowLength, sudokuRows.length);

        int[][] points = new int[rowLength][rowLength];
        for (int i = 0; i < rowLength; i++) {
            String[] sudokuDigits = sudokuRows[i].split(" ");
            validateSudokuElementsLength(rowLength, sudokuDigits.length);
            int[] row = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = Integer.parseInt(sudokuDigits[j]);
            }
            points[i] = row;
        }
        return points;
    }

    private void validateSudokuElements(String inputSudokuData) {
        if (!inputSudokuData.matches("^[0-9\\n ]+$")) {
            throw new RuntimeException("inputSudokuData can contain positive numbers, spaces and new line characters only!");
        }
    }

    private void validateSudokuElementsLength(int expectedLength, int actualLength) {
        if (expectedLength != actualLength) {
            throw new RuntimeException("Invalid sudoku configuration.");
        }
    }
}
