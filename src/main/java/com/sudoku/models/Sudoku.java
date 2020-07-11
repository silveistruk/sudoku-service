package com.sudoku.models;

import com.sudoku.models.elements.Column;
import com.sudoku.models.elements.Square;
import com.sudoku.models.elements.Point;
import com.sudoku.models.elements.Row;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public abstract class Sudoku {
    protected final Point[][] points;
    protected final Row[] rows;
    protected final Column[] columns;
    protected final Square[][] squares;
    protected final HashSet<Integer> uncompletedDigits;

    public Sudoku(int size, int[][] intPoints) {
        validateSudoku(size, intPoints);
        points = new Point[intPoints.length][intPoints.length];
        rows = new Row[intPoints.length];
        columns = new Column[intPoints.length];
        squares = new Square[size][size];
        uncompletedDigits = new HashSet<>(intPoints.length, 1);
        readySudoku(size, intPoints);
    }

    private void validateSudoku(int size, int[][] intPoints) {
        int rowLength = intPoints.length;
        validateSize(size);
        Set<Integer> numbers;
        for (int[] row: intPoints) {
            numbers = new HashSet<>(intPoints.length, 1);
            for (int digit : row) {
                checkRepeatedNumbers(numbers, digit);
            }
        }
        for (int i = 0; i < intPoints.length; i++) {
            numbers = new HashSet<>(intPoints.length, 1);
            for (int[] intPoint : intPoints) {
                checkRepeatedNumbers(numbers, intPoint[i]);
            }
        }
        for (int i = 0; i < size; i++) {

        }
    }

    private void checkRepeatedNumbers(Set<Integer> numbers, int digit) {
        if (digit != 0 && !numbers.add(digit)) {
            throw new RuntimeException("Invalid sudoku. Numbers in the row, column and square can't be repeated.");
        }
    }

    private void validateSize(int size) {
        if (size != 3 && size != 4) {
            throw new RuntimeException("Unexpected size. It must be 3 or 4");
        }
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

    private void addUncompletedDigits(int[] numbersCountToSearch) {
        for (int i = 1; i <= numbersCountToSearch.length - 1; i++) {
            if (numbersCountToSearch[i] < numbersCountToSearch.length - 1) {
                uncompletedDigits.add(i);
            }
        }
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
}
