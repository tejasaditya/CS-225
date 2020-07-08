// Tejas Aditya
// CS 143
// HW#1 Sudoku Core Topics: 2D arrays, reading from a file, creating a class (fields, constructors, toString)
//
// This program will read a sudoku string from the given file, create template sudoku board
// and it also provides the function to print the newly created sudoku board.

import java.io.*;

public class SudokuBoard {

    private int[][] board;  // declaring the board array globally but inaccessible outside of class due to being private

    // constructor to set-up board using given file
    public SudokuBoard(String filename) throws Exception {  //throws FileNotFoundException when unable to access specified file
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);   // opening and reading the file
        BufferedReader br = new BufferedReader(fileReader);
        char nextVal;
        board = new int[9][9];  // initializing the board

        for (int row = 0; row < 9; row++) { // for the 9 rows in the file
            for (int col = 0; col < 9; col++) { // for the 9 columns in the row
                nextVal = (char) br.read(); // read the next character
                while(nextVal == 10 || nextVal == 13){  // if newline characters, then continue reading
                    nextVal = (char) br.read();
                }
                if (nextVal == '.') {   // when reading a period from the file, enter 0 in the board to denote empty space
                    board[row][col] = 0;
                } else if (nextVal >= '0' && nextVal <= '9') {  // else when reading number, input it to the board
                    board[row][col] = nextVal - '0';    //subtract the ascii value of 0 to get integer val of num
                }
                else
                    continue;   //else ignore char
            }
        }
        br.close(); // close reader stream
        fileReader.close(); // close file
    }

    // prints the sudoku board to screen
    public String toString() {
        for (int row = 0; row < board.length; row++) {  // for rows present in board
            for (int col = 0; col < board[0].length; col++) {   // for each column present in each row
                System.out.print(board[row][col] + " ");    // print the value at location spacing around it for styling
                if (col == 2 || col == 5) { // if at the edge of each 3*3 group in sudoku, print border lines
                    System.out.print("| ");
                }
            }
            if (row == 2 || row == 5) { // if at the edge of each 3*3 group in sudoku, print border lines
                System.out.println();
                System.out.print("---------------------");
            }
            if (row < 8) {  //removing extra lines after printing board
                System.out.println();
            }
        }
        return "";
    }
}