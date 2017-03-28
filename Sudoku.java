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
        s.solve(s.sudoku, 0, 0);

    }

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

    public boolean solve(int[][] sudoku, int row, int col) {

        if (row == sudoku.length) {

            print(sudoku);

            return true;

        }

        if (sudoku[row][col] == 0) {

            for (int num = 1; num < sudoku.length + 1; num++) {

                if ((checkRow(sudoku, row, num) && !checkCol(sudoku, col, num)) && checkBox(sudoku, row % 3, col % 3, num)) {
                    sudoku[row][col] = num;

                }
                else
                {

                }

            }
            next(sudoku, row, col);

        } else {
            next(sudoku, row, col);
        }

        return false;
    }

    public boolean checkRow(int[][] sudoku, int row, int num) {
        for (int i = 0; i < sudoku[0].length; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        return true;
    }

    public boolean checkCol(int[][] sudoku, int col, int num) {
        for (int i = 0; i < sudoku[0].length; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        return true;
    }

    public boolean checkBox(int[][] sudoku, int row, int col, int num) {
        //System.out.println(row + " " + col);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.println(row + " " + col);
                if (sudoku[row + i][col + j] == num) {

                   /* System.out.println(row);
                    System.out.println(col);
                    System.out.println(row + i);
                    System.out.println(col + j);*/
                    return false;
                }
            }
        }

        return true;
    }

    public void next(int[][] sudoku, int row, int col) {
       // System.out.println(col + " " + row);
        if (col > 7) {
           // System.out.println(col + " " + row);
            solve(sudoku, row + 1, 0);
        } 
        else {
         //  System.out.println(col + " " + row);
            solve(sudoku, row, col + 1);

        }
    }

    /*   Initialize 2D array with 81 empty grids (nx = 9, ny = 9)
 Fill in some empty grid with the known values
 Make an original copy of the array
 Start from top left grid (nx = 0, ny = 0), check if grid is empty
 if (grid is empty) {
   assign the empty grid with values (i)
   if (no numbers exists in same rows & same columns same as (i) & 3x3 square (i) is currently in)
     fill in the number
   if (numbers exists in same rows | same columns same as (i) | 3x3 square (i) is currently in)
     discard (i) and repick other values (i++)
 }
 else {
   while (nx < 9) {
     Proceed to next row grid(nx++, ny)
     if (nx equals 9) {
       reset nx = 1
       proceed to next column grid(nx,ny++)
       if (ny equals 9) {
         print solution
       }
     }
   }
 }
     */
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
