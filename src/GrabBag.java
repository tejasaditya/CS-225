// Tejas Aditya
// CS 143
// Implementing GrabBag Topics: Iterator and ArrayList
//
// The program in addition to the functionality mentioned below
// also creates a custom defined iterator and implements it.
// The iterator can check if there are more values and go to next
// value. The iterator denies a user the ability to remove a value.

/*
   This class is used to make a group of data where you can
   `grab` a random value.
*/

import java.util.*;

public class GrabBag<E> implements Iterable<E> {
   private ArrayList<E> bag;

   public GrabBag() {
      bag = new ArrayList<E>();
   }
   
   public void add(E data) {
      bag.add(data);
   }
   
   public E grab() {
      Random r = new Random();
      E removed = bag.remove(r.nextInt(bag.size()));
      return removed;
   }
   
   public boolean isEmpty() {
      return bag.size() == 0;
   }
   
   public String toString() {
      return bag.toString();
   }

   public Iterator iterator() {
      return new GrabBagIterator();
   }

   private class GrabBagIterator implements Iterator<E>{
      private int index = 0;  // starting index
      @Override
      public boolean hasNext() {
         return index<bag.size();   //if current index is less than total elements
      }                             // there are more elements present

      @Override
      public E next() {
         return bag.get(index++);   //get the current value and go next index
      }

      @Override
      public void remove() {     // stop the user from removing values using iterator
         throw new UnsupportedOperationException("Do not remove using the Iterator.");
      }
   }
}