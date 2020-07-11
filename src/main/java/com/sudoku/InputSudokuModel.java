package com.sudoku;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InputSudokuModel {
    private final int size;
    private final String inputSudoku;

    @Builder
    public InputSudokuModel(int size, String inputSudoku) {
        this.size = size;
        this.inputSudoku = inputSudoku;
    }
}
