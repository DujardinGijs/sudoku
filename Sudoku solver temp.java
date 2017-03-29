package Sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Robin
 */
public class Sudoku {

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        s.solve(0, 0);
        s.print(s.sudoku);

    }

    //private int[][] sudokus = new int[9][9];
    private int[][] solution
            = {{2, 1, 5, 4, 3, 8, 9, 7, 6},
            {8, 4, 9, 1, 6, 7, 5, 3, 2},
            {6, 7, 3, 9, 5, 2, 4, 1, 8},
            {4, 2, 7, 5, 9, 3, 8, 6, 1},
            {3, 5, 1, 6, 8, 4, 7, 2, 9},
            {9, 8, 6, 2, 7, 1, 3, 4, 5},
            {1, 9, 8, 7, 4, 6, 2, 5, 3},
            {5, 6, 4, 3, 2, 9, 1, 8, 7},
            {7, 3, 2, 8, 1, 5, 6, 9, 4}};

    private int[][] sudoku
            = {{0, 1, 0, 0, 3, 8, 0, 0, 6},
            {0, 4, 0, 0, 0, 7, 5, 0, 2},
            {6, 0, 3, 9, 0, 0, 4, 1, 0},
            {0, 0, 7, 5, 0, 3, 8, 0, 0},
            {0, 5, 1, 6, 0, 4, 0, 0, 0},
            {9, 0, 0, 2, 0, 0, 3, 4, 0},
            {0, 0, 8, 0, 4, 0, 2, 0, 3},
            {5, 6, 0, 0, 0, 0, 0, 8, 7},
            {7, 0, 2, 0, 1, 5, 0, 9, 0}};

    public void setNumber(int x, int y, int number) {
        sudoku[x][y] = number;
    }

    public int getNumber(int x, int y) {
        return sudoku[x][y];
    }

    public boolean solve(int row, int col) {

        if (row == sudoku.length) {

            return true;

        }

        if (sudoku[row][col] != 0) {
            if (solve(col == sudoku[col].length - 1 ? (row + 1) : row, (col + 1) % 9)) {
                return true;
            }
        } else {
            for (int num = 0; num < sudoku.length + 1; num++) {

                if (checkRow(row, num) && checkCol(col, num) && checkBox(row, col, num)) {
                    sudoku[row][col] = num;
                    //System.out.println("value:" + row + " " + col + " " + num);

                    if (solve(col == sudoku[col].length - 1 ? (row + 1) : row, (col + 1) % 9)) {
                        return true;
                    } else {

                        sudoku[row][col] = 0;

                    }
                }

            }

        }

        return false;
    }

    public boolean checkRow(int row, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        return true;
    }

    public boolean checkCol(int col, int num) {
        for (int i = 0; i < sudoku[0].length; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        return true;
    }

    public boolean checkBox(int row, int col, int num) {

        int startrow = row / 3 * 3;
        int startcol = col / 3 * 3;
        for (int i = startrow; i < startrow + 3; i++) {
            for (int j = startcol; j < startcol + 3; j++) {
                //System.out.println(row + " " + col);
                if (!(i == row && j == row)) {
                    if (sudoku[i][j] == num) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void print(int[][] game) {
        System.out.println();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(" " + game[y][x]);
            }
            System.out.println();
        }
    }
}
