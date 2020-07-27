// Tejas Aditya
// CS 143
// Exploring Iterators Core Topics: Iterators, ArrayList, for-each loop
//
// This is the runner program for a user defined iterator class within
// the GrabBag class. The program compares the functionality and input
// of the custom defined class with the predefined Iterator class.
// A certain number of randomly named values are added and then printed.
import java.util.*;

public class ExploringIterators {
   public static void main(String[] args) {
      Random rand = new Random();
      GrabBag<String> things = new GrabBag<>();
      populate(things, 5, rand); // add 5 elements to the grab bag
      System.out.println(things.toString()); //print the bag elements
      for (String thing : things){
         System.out.print(thing+" ");  // print bag elements using for each loop
      }
      System.out.println();
      Iterator it = things.iterator(); // create Iterator
      while(it.hasNext()) {
         System.out.print(it.next()+ " ");   // print elements using iterator
      }
   }
      // add num things to bag with random numbers assigned
   public static void populate(GrabBag<String> bag, int num, Random r) {
      for (int i = 0; i < num; i++) {
         int temp = r.nextInt(100)+1;  // get random number between 1-100
         bag.add("Thing#"+temp); // add the element to the bag
      }
   }
}

/*
[Thing#34, Thing#70, Thing#33, Thing#46, Thing#100]
Thing#34 Thing#70 Thing#33 Thing#46 Thing#100
Thing#34 Thing#70 Thing#33 Thing#46 Thing#100
 */