// Tejas Aditya
// CS 143
// Writing a Recursive Method
//
// This program contains four different recursive functions.

public class WritingRecursiveMethods {

   /*
      Write a recursive method called digitProduct, that takes an 
      integer n as a parameter and returns the product of all non-zero 
      digits of n. If passed a negative number, the method should return 
      the negative product of the digits. 
   */
   public static int digitProduct(int n) {
      if(n < 0){
         return -digitProduct(-n);
      }
      else if(n/10 == 0 && n != 0){
         return n;
      }
      else if(n%10 != 0){
            return (n%10)*digitProduct(n/10);
      }
      else{
         return digitProduct(n/10);
      }
   }
   
   /*
      Write a recursive method called pattern that takes as parameters 
      an int n and an int m and that returns a string containing m dots 
      surrounded by n pairs of square brackets (one pair is "[]"). 
   */
   public static String pattern(int n, int m) {
      if(n == 1){
         return "["+pattern(n-1, m)+"]";
      }
      else if(n >1){
         return "["+pattern(n-1,m)+"]";
      }
      else if(n == 0 && m == 1){
         return ".";
      }
      else if(n == 0 && m > 1){
         return "."+pattern(n, m-1);
      }
      return "";
   }
   /*
      Write a method commonChars that takes two strings as parameters 
      and that returns a string representing the characters they have 
      in common. The characters that are different between the two 
      strings should be represented by a "." in the returned string. 
      You can assume the two strings passed in to the method contain 
      no "." characters.
   */
   public static String commonChars(String s1, String s2) {
      if(s1.length() == 0 || s2.length() == 0){
         return "";
      }
      else if(!s1.substring(0,1).equals(s2.substring(0,1))){
         return "."+commonChars(s1.substring(1),s2.substring(1));
      }
      else{
         return s1.substring(0,1)+commonChars(s1.substring(1),s2.substring(1));
      }
   }
   
   /*
      Write a method countToBy that takes integer parameters n and m 
      and that produces output indicating how to count to n in 
      increments of m.
   */
   public static void countToBy(int n, int m) {
      if(m<1){
         throw new IllegalArgumentException();
      }
      if((n-m) > 0){
         countToBy(n-m, m);
         System.out.print(", ");

      }
      System.out.print(n);
   }

   public static void main(String[] args) {
      System.out.println("digitProduct(62) = " + digitProduct(62));       // 12
      System.out.println("digitProduct(-151) = " + digitProduct(-151));   // -5
      System.out.println("digitProduct(12345) = " + digitProduct(12345)); // 120
      System.out.println();
      
      System.out.println("pattern(0, 1) = " + pattern(0, 1));     // "."
      System.out.println("pattern(1, 2) = " + pattern(1, 2));     // "[..]"
      System.out.println("pattern(3, 0) = " + pattern(3, 0));     // "[[[]]]"
      System.out.println("pattern(3, 2) = " + pattern(3, 2));     // "[[[..]]]"
      System.out.println();
      
      System.out.print("\ncommonChars(\"foo\", \"oof\") = " + commonChars("foo", "oof"));                // ".o."
      System.out.print("\ncommonChars(\"dog person\", \"cat perSon\") = " + commonChars("dog person", "cat perSon"));  // "... per.on"
      System.out.print("\ncommonChars(\"hello\", \"jello\") = " + commonChars("hello", "jello"));            // ".ello"
      System.out.println();
      
      System.out.print("\ncountToBy(34, 5) = ");
      countToBy(34, 5);     // 4, 9, 14, 19, 24, 29, 34 
      System.out.print("\ncountToBy(3, 6) = ");
      countToBy(3, 6);      // 3
      System.out.print("\ncountToBy(17, 3) = "); 
      countToBy(17, 3);     // 2, 5, 8, 11, 14, 17
      System.out.println("\n");
   }
   
}

/*
digitProduct(62) = 12
digitProduct(-151) = -5
digitProduct(12345) = 120

pattern(0, 1) = .
pattern(1, 2) = [..]
pattern(3, 0) = [[[]]]
pattern(3, 2) = [[[..]]]


commonChars("foo", "oof") = .o.
commonChars("dog person", "cat perSon") = ... per.on
commonChars("hello", "jello") = .ello

countToBy(34, 5) = 4, 9, 14, 19, 24, 29, 34
countToBy(3, 6) = 3
countToBy(17, 3) = 2, 5, 8, 11, 14, 17


 */