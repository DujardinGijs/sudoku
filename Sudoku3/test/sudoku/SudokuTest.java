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

    /**
     * Test of main method, of class Sudoku.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Sudoku.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class Sudoku.
     */
    @org.junit.Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int x = 0;
        int y = 0;
        int number = 0;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.setNumber(x, y, number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberFromSudoku method, of class Sudoku.
     */
    @org.junit.Test
    public void testGetNumberFromSudoku() {
        System.out.println("getNumberFromSudoku");
        int x = 0;
        int y = 0;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.getNumberFromSudoku(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberFromSolution method, of class Sudoku.
     */
    @org.junit.Test
    public void testGetNumberFromSolution() {
        System.out.println("getNumberFromSolution");
        int x = 0;
        int y = 0;
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.getNumberFromSolution(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSudoku method, of class Sudoku.
     */
    @org.junit.Test
    public void testGetSudoku() {
        System.out.println("getSudoku");
        Sudoku instance = new Sudoku();
        int[][] expResult = null;
        int[][] result = instance.getSudoku();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHint method, of class Sudoku.
     */
    @org.junit.Test
    public void testGetHint() {
        System.out.println("getHint");
        Sudoku instance = new Sudoku();
        String[] expResult = null;
        String[] result = instance.getHint();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Sudoku.
     */
    @org.junit.Test
    public void testSolve() {
        System.out.println("solve");
        int row = 0;
        int col = 0;
        Sudoku instance = new Sudoku();
        boolean expResult = false;
        boolean result = instance.solve(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
