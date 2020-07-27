// This program will create a new object of the Job Simulation class
// and run the cycle function defined in the Job Simulation class
// until stopped by user.
import java.util.*;

public class JobSimulationEngine {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      // Start a simulation with 10 workers, 6 jobs
      JobSim simulation = new JobSim(10, 6);
      System.out.println("As the simulation begins");
      System.out.println(simulation);
      System.out.println();
      
      String again = "";
      do {
         simulation.cycle();
         System.out.println(simulation);
         System.out.print("Press enter to cycle, anything else to quit...");
         again = console.nextLine();
      } while(again.equals(""));
      
      System.out.println("Simulation Ended");
   }
}

/*
As the simulation begins
Employed: [Worker #1, Worker #2, Worker #3, Worker #4, Worker #5, Worker #6]
Waitlist: [Worker #7, Worker #8, Worker #9, Worker #10]


------Cycle 1-------
Managers roll a 4
----------------
FIRE:  Worker #6
FIRE:  Worker #5
FIRE:  Worker #4
FIRE:  Worker #3
HIRE:  Worker #7
HIRE:  Worker #8
HIRE:  Worker #9
HIRE:  Worker #10
Employed: [Worker #1, Worker #2, Worker #7, Worker #8, Worker #9, Worker #10]
Waitlist: [Worker #6, Worker #5, Worker #4, Worker #3]

Press enter to cycle, anything else to quit...

------Cycle 2-------
Managers roll a 2
----------------
FIRE:  Worker #10
FIRE:  Worker #9
HIRE:  Worker #6
HIRE:  Worker #5
Employed: [Worker #1, Worker #2, Worker #7, Worker #8, Worker #6, Worker #5]
Waitlist: [Worker #4, Worker #3, Worker #10, Worker #9]

Press enter to cycle, anything else to quit...------Cycle 3-------
Managers roll a 6
----------------
FIRE:  Worker #5
FIRE:  Worker #6
FIRE:  Worker #8
FIRE:  Worker #7
FIRE:  Worker #2
FIRE:  Worker #1
HIRE:  Worker #4
HIRE:  Worker #3
HIRE:  Worker #10
HIRE:  Worker #9
HIRE:  Worker #5
HIRE:  Worker #6
Employed: [Worker #4, Worker #3, Worker #10, Worker #9, Worker #5, Worker #6]
Waitlist: [Worker #8, Worker #7, Worker #2, Worker #1]

Press enter to cycle, anything else to quit...end
Simulation Ended
 */