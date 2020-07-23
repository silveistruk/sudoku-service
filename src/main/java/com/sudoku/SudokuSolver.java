package com.sudoku;

import com.sudoku.models.Sudoku;
import com.sudoku.models.data.SudokuDigitData;
import com.sudoku.models.elements.SudokuBlock;

import java.util.Set;
import java.util.stream.Collectors;

public class SudokuSolver {
    private Sudoku sudoku;

    public SudokuSolver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public void solveSudoku() {
        Set<SudokuDigitData> digitsToFind = sudoku.getUncompletedDigits()
                .stream()
                .filter(data -> data.getCountInSudoku() < sudoku.getSize() * sudoku.getSize())
                .collect(Collectors.toSet());
        for (SudokuDigitData digitData : digitsToFind) {
            for (int i = 0; i < sudoku.getSize(); i++) {
                if (isOnlyOneBlockHasNotDigit(sudoku.getSize(), i, digitData.getDigit(), sudoku.getRows())) {

//                if () {}
                }
            }
        }
    }

    private boolean isOnlyOneBlockHasNotDigit(int size, int blocksPosition, int digit, SudokuBlock[] sudokuBlocks) {
        int countOfAbsentDigits = 0;
        for (int i = 0; i < size; i++) {
            if (!sudokuBlocks[size * blocksPosition + i].containsDigit(digit)) {
                countOfAbsentDigits++;
            }
        }
        return countOfAbsentDigits == 1;
    }
}
