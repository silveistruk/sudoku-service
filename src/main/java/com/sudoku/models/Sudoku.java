package com.sudoku.models;

import com.sudoku.models.data.SudokuDigitData;
import com.sudoku.models.elements.Column;
import com.sudoku.models.elements.Point;
import com.sudoku.models.elements.Row;
import com.sudoku.models.elements.Square;
import lombok.Getter;

import java.util.TreeSet;

@Getter
public abstract class Sudoku {
    protected final int size;
    protected final Point[][] points;
    protected final Row[] rows;
    protected final Column[] columns;
    protected final Square[][] squares;
    protected final TreeSet<SudokuDigitData> uncompletedDigits;

    public Sudoku(int size, int[][] intPoints) {
        SudokuValidator.validateSudoku(size, intPoints);
        this.size = size;
        points = new Point[intPoints.length][intPoints.length];
        rows = new Row[intPoints.length];
        columns = new Column[intPoints.length];
        squares = new Square[size][size];
        uncompletedDigits = new TreeSet<>(this::compareDigitsToOrderSearching);
        readySudoku(size, intPoints);
    }

    private void readySudoku(int size, int[][] intPoints) {
        fillInPoints(size, intPoints);
        fillInRowsAndColumns(size);
        fillInSquares(size);
    }

    private void fillInPoints(int size, int[][] intPoints) {
        int[] numbersCountToSearch = new int[intPoints.length + 1];
        for (int i = 0; i < intPoints.length; i++) {
            for (int j = 0; j < intPoints.length; j++) {
                points[i][j] = new Point(size, intPoints[i][j]);
                numbersCountToSearch[intPoints[i][j]]++;
            }
        }
        addUncompletedDigits(numbersCountToSearch);
    }

    private void fillInRowsAndColumns(int size) {
        for (int i = 0; i < size * size; i++) {
            rows[i] = new Row(size, points[i]);
            columns[i] = new Column(size, i, points);
        }
    }

    private void fillInSquares(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squares[i][j] = new Square(size, i, j, points);
            }
        }
    }

    private void addUncompletedDigits(int[] numbersCountToSearch) {
        for (int i = 1; i <= numbersCountToSearch.length - 1; i++) {
            if (numbersCountToSearch[i] < numbersCountToSearch.length - 1) {
                uncompletedDigits.add(new SudokuDigitData(i, numbersCountToSearch[i]));
            }
        }
    }

    private int compareDigitsToOrderSearching(SudokuDigitData digitsData1, SudokuDigitData digitsData2) {
        int firstLevelCompare = digitsData2.getCountInSudoku() - digitsData1.getCountInSudoku();
        return firstLevelCompare != 0 ? firstLevelCompare : digitsData1.getDigit() - digitsData2.getDigit();
    }
}
