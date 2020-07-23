package com.sudoku.models.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SudokuDigitData {
    private int digit;
    private int countInSudoku;

    public void addCountInSudoku() {
        countInSudoku++;
    }
}
