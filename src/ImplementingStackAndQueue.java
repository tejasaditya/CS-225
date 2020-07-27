/*
The program creates a stack and queue using predefined or
user defined classes. It then add or removes value when prompted by user,
printing the updated stack and queue simultaneously.
The program ends when the user gives the command .
*/
import java.util.*;

public class ImplementingStackAndQueue {

   public static void main(String[] args) {
      MyStack<Integer> stack = new MyStack<>();
      //Stack<Integer> stack = new Stack<>();
      MyQueue<Integer> queue = new MyQueue<>();
      //Queue<Integer> queue = new LinkedList<>();
      
      Random r = new Random();
      Scanner console = new Scanner(System.in);
      
      String again = "";
      do {
         System.out.print("add, remove, or end? > ");
         again = console.nextLine().toLowerCase();
         if(again.startsWith("a")) {
            int x = r.nextInt(1000) + 1;
            stack.push(x);
            queue.add(x);
         }
         else if(again.startsWith("r")) {
            stack.pop();
            queue.remove();
         }
         System.out.println("stack = " + stack);
         System.out.println("queue = " + queue);
      } while(again.startsWith("a") || again.startsWith("r"));
   
   }

}

/*
add, remove, or end? > a
stack = [613]
queue = [613]
add, remove, or end? > a
stack = [613, 486]
queue = [613, 486]
add, remove, or end? > a
stack = [613, 486, 357]
queue = [613, 486, 357]
add, remove, or end? > r
stack = [613, 486]
queue = [486, 357]
add, remove, or end? > r
stack = [613]
queue = [357]
add, remove, or end? > e
stack = [613]
queue = [357]

 */