// Tejas Aditya
// CS 143
// Implementing MyQueue Core Topics: Queue and ArrayList
//
// This is a user defined class for a queue implemented using
// ArrayList. It provides functions to add a value to a queue,
// remove a value, get queue size, check if it's empty, and
// print it. The function list and their definitions are given below.

/*
MyQueue<E>()      Constructs a new queue with elements of type E 
add(E value)      Adds val to the back of the queue
remove()          Removes the first value from the queue; throws a NoSuchElementException if the queue is empty
isEmpty()         Returns true if the queue has no elements
size()            Returns the number of elements in the queue
*/

import java.util.*;

public class MyQueue<E> {
    private ArrayList<E> queue;

    public MyQueue() {
        queue = new ArrayList();
    }

    public void add(E val) {
        queue.add(val);
    }

    public E remove() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public String toString() {
        return queue.toString();
    }
}

