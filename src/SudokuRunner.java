// Tejas Aditya
// CS 143
// HW#1 Sudoku Core Topics: 2D arrays, reading from a file, creating a class (fields, constructors, toString)
//
// This program will create a new object of SudokuBoard class and
// print the board.

public class SudokuRunner {
    public static void main(String[] args) throws Exception {
        SudokuBoard sudokuBoard = new SudokuBoard("src\\data1-1.sdk");  // create object of SudokuBoard class and initialize constructor with filepath
        System.out.println(sudokuBoard); //print the board
    }
}

/*
2 0 0 | 1 0 5 | 0 0 3
0 0 0 | 5 4 0 | 0 0 7
1 0 0 | 0 0 1 | 0 2 0
---------------------
3 0 8 | 0 0 0 | 6 0 2
8 0 7 | 3 0 4 | 0 0 0
0 0 0 | 0 0 0 | 0 0 0
---------------------
0 1 0 | 5 3 0 | 9 8 0
6 0 0 | 0 2 0 | 7 0 1
0 6 0 | 0 0 0 | 8 1 0

 */