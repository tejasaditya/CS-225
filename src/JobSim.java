// Tejas Aditya
// CS 143
// Job Simulation Core Topics: Stacks and Queues
//
//

import java.util.*;

public class JobSim {

    // initialize the employee list and job seeker list
    Queue<String> waitlist = new LinkedList<String>();
    Stack<String> employed = new Stack<String>();
    int i;  //  initialize cycle counter

    public JobSim(int workers, int jobs) {
        for (int i = 1; i <= workers; i++) {    //Adding all workers to the queue
            waitlist.add("Worker #" + i);
        }

        for (int i = 0; i < jobs; i++) {        //Add workers from queue to available
            employed.push(waitlist.remove());   //employee positions in order
        }
        i = 0;
    }

    public String toString() {
        System.out.println("Employed: " + employed);    //print the employee list
        System.out.println("Waitlist: " + waitlist);    // print the queue of job seekers
        return "";
    }

    public void cycle() {
        i++;    // increase cycle counter
        System.out.println("------Cycle " + i + "-------");
        int roll = (int) ((Math.random() * 6) + 1);         //calculate the random roll value for 6 sided dice
        System.out.println("Managers roll a " + roll);
        System.out.println("----------------");
        for (int j = 0; j < roll; j++) {
            String firedWorker = employed.pop();        // remove worker from employee list to fire them
            waitlist.add(firedWorker);              // add worker to wait list queue
            System.out.println("FIRE:  " + firedWorker);
        }
        for (int j = 0; j < roll; j++) {
            System.out.println("HIRE:  " + employed.push(waitlist.remove()));   //hire workers from wait list
        }
    }
}