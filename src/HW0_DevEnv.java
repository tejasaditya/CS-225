// Tejas Aditya
// CS 143
// HW Core Topics: setting up my dev environment
//
// This program will output "Hello World" five times on the screen
// and repeat the process until the user requests it.


import java.util.*;

public class HW0_DevEnv {
    public static void main(String[] args) {
        String str;
        do {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello World!");
            }
            Scanner in = new Scanner(System.in);
            //Get input String
            System.out.println("Would you like to see Hello World again?");
            str = in.nextLine();
        } while (str.equalsIgnoreCase("yes"));
    }
}

/*
Hello World!
Hello World!
Hello World!
Hello World!
Hello World!
Would you like to see Hello World again?
 */