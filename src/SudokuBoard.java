// Tejas Aditya
// CS 143
// HW#3 Sudoku Core Topics: recursive backtracking
//
// This program will read a sudoku string from the given file and create template sudoku board.
// It will then solve it cell by cell using recursive backtracking. It finds an empty cell and
// checks if a number between 1 and 9 is valid input for that
// location(taking into account all possible conflicts:row, column, mini-square).
// If this is true, the process continues. Otherwise, the cell is reset to 0 and the next value is checked.
// It also provides functions to print the sudoku board, check if it's a valid board and
// check if it's been solved.

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
                while (nextVal == 10 || nextVal == 13) {  // if newline characters, then continue reading
                    nextVal = (char) br.read();
                }
                if (nextVal == '.') {   // when reading a period from the file, enter 0 in the board to denote empty space
                    board[row][col] = 0;
                } else if (nextVal >= '0' && nextVal <= '9') {  // else when reading number, input it to the board
                    board[row][col] = nextVal - '0';    //subtract the ascii value of 0 to get integer val of num
                } else
                    board[row][col] = 10;   //else ignore char
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

    // function to check if the board is valid
    public boolean isValid() {
        if (validData() == false || validRow() == false || validCol() == false || validSquare() == false) {
            return false;   // if any test fails, return false
        }
        return true;
    }

    // checks if all data within the board is an accepted value
    private boolean validData() {
        for (int row = 0; row < board.length; row++) {  // for rows present in board
            for (int col = 0; col < board[0].length; col++) {   // for each cell present in each row
                if (board[row][col] > 9 || board[row][col] < 0) { // if data is not between 0-9, return false
                    return false;
                }
            }
        }
        return true;
    }

    // checks if all data in the row is unique(ignoring blanks)
    private boolean validRow() {
        Set<Integer> set = new HashSet<Integer>();
        for (int row = 0; row < board.length; row++) {  // for rows present in board
            for (int col = 0; col < board[0].length; col++) {   // for each column present in each row
                if (board[row][col] != 0) {
                    if (set.contains(board[row][col])) {    // if duplicate found, return false
                        return false;
                    } else {
                        set.add(board[row][col]);   // if value being read is not in the set add it as key
                    }
                }
            }
            set.clear();    // clear set for new row
        }
        return true;
    }

    // checks if all data in the column is unique(ignoring blanks)
    private boolean validCol() {
        Set<Integer> set = new HashSet<Integer>();
        for (int col = 0; col < board[0].length; col++) {  // for each col present in board
            for (int row = 0; row < board.length; row++) {   // for each cell in each col
                if (board[row][col] != 0) {
                    if (set.contains(board[row][col])) { // if duplicate found, return false
                        return false;
                    } else {
                        set.add(board[row][col]);   //if value being read is not in the set add it as key
                    }
                }
            }
            set.clear();    // clear set for new column
        }
        return true;
    }

    // provided helper method from instructor
    private int[][] miniSquare(int spot) {
        int[][] mini = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                // whoa - wild! This took me a solid hour to figure out (at least)
                // This translates between the "spot" in the 9x9 Sudoku board
                // and a new mini square of 3x3
                mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
            }
        }
        return mini;
    }

    //// checks if all data in the mini-sqaure is unique(ignoring blanks)
    private boolean validSquare() {
        Set<Integer> set = new HashSet<Integer>();
        for (int square = 1; square < 10; square++) {
            int[][] mini = miniSquare(square);
            for (int row = 0; row < mini.length; row++) {  // for rows present in square
                for (int col = 0; col < mini[0].length; col++) {   // for each column present in each row
                    {
                        if (mini[row][col] != 0)
                            if (set.contains(mini[row][col])) {     //if duplicate found, return false
                                return false;
                            } else {
                                set.add(mini[row][col]);    //if value being read is not in the set add it as key
                            }
                    }
                }
            }
            set.clear(); // clear set for new mini-square
        }
        return true;
    }

    // checks if the board is corectly solved
    public boolean isSolved() {
        if (!isValid()) {   //if the board is not valid, the board is automatically not solved
            return false;
        }

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int row = 0; row < board.length; row++) {  // for rows present in board
            for (int col = 0; col < board[0].length; col++) {   // for each column present in each row
                if (!count.containsKey(board[row][col])) {
                    count.put(board[row][col], 1);  //if value being read is not in map add it
                } else {
                    count.put(board[row][col], count.get(board[row][col]) + 1); // else increase the count for it
                }
            }
        }

        if (count.size() != 9) {    //if 9 pairs of key and values not present, then board is not solved
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (count.get(i) != 9) {    // if each key doesn't have 9 instances, then board is not solved
                return false;
            }
        }
        return true;
    }

    // this function uses recursive backtracking to solve a sudoku board
    public boolean solve() {
        if (isValid() == false) {   // if input board is invalid, return false immediately
            return false;
        } else if (isSolved() == true) {    //if input board is already solved, return true immediately
            return true;
        } else {
            for (int row = 0; row < board.length; row++) {  // for each row
                for (int col = 0; col < board[0].length; col++) {   // for each cell in the row
                    if (board[row][col] == 0) { // if the space is empty
                        for (int num = 1; num < 10; num++) {   //for each value between 1 and 9
                            board[row][col] = num;  // replace empty cell with value
                            if (solve() == true) {  //if the value solves the board return true
                                return true;
                            } else {    // else change it back to being empty and check next value
                                board[row][col] = 0;
                            }
                        }
                    }

                }
            }
        }
        return false;   // if none of the values work return false
    }
}