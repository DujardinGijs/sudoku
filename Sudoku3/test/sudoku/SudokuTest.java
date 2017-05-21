/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test.*;
import static org.junit.Assert.*;

/**
 *
 * @author Robin
 */
public class SudokuTest {
    
    public SudokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testSetNumber() {
        int x = 0;
        int y = 0;
        int number = 2;
        Sudoku instance = new Sudoku();
        int expResult = 2;
        int result = instance.setNumber(x, y, number);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testSetWrongNumber() {
        int x = 0;
        int y = 0;
        int number = 10;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.setNumber(x, y, number);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testSetFixedNumber() {
        int x = 0;
        int y = 1;
        int number = 10;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.setNumber(x, y, number);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testGetNumberFromSudoku() {

        int x = 0;
        int y = 1;
        Sudoku instance = new Sudoku();
        int expResult = 1;
        int result = instance.getNumberFromSudoku(x, y);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetNumberFromSudokuOutOfBounds() {
        int x = 9;
        int y = 1;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.getNumberFromSudoku(x, y);
        assertEquals(expResult, result);
        x = 5;
        y = 50;
        expResult = 0;
        result = instance.getNumberFromSudoku(x, y);
        assertEquals(expResult, result);

    }

    @org.junit.Test
    public void testGetNumberFromSolution() {
        int x = 5;
        int y = 8;
        Sudoku instance = new Sudoku();
        int expResult = 5;
        int result = instance.getNumberFromSolution(x, y);
        assertEquals(expResult, result);

    }

    
    @org.junit.Test
    public void testGetNumberFromSolutionOutOfBounds() {
        int x = 36;
        int y = 2;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.getNumberFromSolution(x, y);
        assertEquals(expResult, result);

    }    


    
}
