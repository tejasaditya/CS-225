// This program will create a new object of SudokuBoard class using the provided input.
// It will then preemptively check if the input is already solved or invalid and inform the user.
// Only if the previous conditions aren't true, it then calls the function to solve the
// board and print the output board.

public class SudokuSolverEngine {

   public static void main(String[] args) throws Exception{
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard board = new SudokuBoard("boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();

      if(!board.isValid()){
         System.out.println("This board is invalid and cannot be solved");
      }
      else if(board.isSolved()){
         System.out.println("This board is already solved");
      }
      else{
         System.out.print("Solving board...");
         long start = System.currentTimeMillis();
         board.solve();
         long stop = System.currentTimeMillis();
         System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
         System.out.println();
         System.out.println(board);
      }
   }
}

/*
Initial board
0 3 4 | 6 7 8 | 9 1 2
0 7 2 | 1 9 5 | 3 4 8
1 9 8 | 3 4 2 | 5 6 7
---------------------
0 0 9 | 0 6 1 | 4 2 3
0 2 6 | 8 5 3 | 7 9 1
0 1 3 | 9 2 4 | 0 5 6
---------------------
0 6 1 | 5 3 7 | 2 8 4
0 8 0 | 4 1 9 | 6 3 5
3 4 5 | 0 8 6 | 1 7 9

Solving board...SOLVED in 0.962 seconds.

5 3 4 | 6 7 8 | 9 1 2
6 7 2 | 1 9 5 | 3 4 8
1 9 8 | 3 4 2 | 5 6 7
---------------------
8 5 9 | 7 6 1 | 4 2 3
4 2 6 | 8 5 3 | 7 9 1
7 1 3 | 9 2 4 | 8 5 6
---------------------
9 6 1 | 5 3 7 | 2 8 4
2 8 7 | 4 1 9 | 6 3 5
3 4 5 | 2 8 6 | 1 7 9

 */