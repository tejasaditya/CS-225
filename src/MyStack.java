// Tejas Aditya
// CS 143
// Implementing MyStack Core Topics: Stacks and ArrayList
//
// This is a user defined class for a stack implemented using
// ArrayList. It provides functions to push a value to a stack,
// pop a value back, peek at the top value, get stack size, check
// if it's empty, and print it. The function list and their definitions
// are given below.

/*
MyStack<E>()   Constructs a new stack with elements of type E 
push(val)      Places val on top of the stack
pop()          Removes top value from the stack and returns it; throws NoSuchElementException if stack is empty
peek()         Returns top value from the stack without removing it; throws NoSuchElementException if stack is empty
isEmpty()      Returns true if the stack has no elements
size()         Returns the number of elements in the stack
*/

import java.util.*;

public class MyStack<E> {
    private ArrayList stack;

    public MyStack() {
        stack = new ArrayList();
    }

    public void push(E val) {
        stack.add(val);
    }

    public E pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) stack.remove(stack.size() - 1);
    }

    public E peek() {
       if (stack.isEmpty()) {
          throw new NoSuchElementException();
       }
        return (E) stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }

}