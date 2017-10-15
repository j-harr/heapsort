/**
 * class Main
 * contains functions main(), greeting(), initialize(), farewell(), divline(),
 * elapsedtime()
 * test01(), test02(), test03(), and test04()
 * serves as driver for testing heap and HeapSort functionality.
 */
import java.util.*;

public class Main {
    public static void main(String [] args){
        //DECLARATION OF VARIABLES
        String username;
        long timestart;
        long timestop;

        //GREETING AND TIME START
        username = greeting();
        System.out.println(">>Current tester: "+username);
        timestart = System.currentTimeMillis();
        System.out.println(">>Time Start: "+timestart);
        divline();
        //TIMESTOP AND FAREWELL
        timestop = System.currentTimeMillis();
        System.out.println(">>Time Stop: "+timestop);
        farewell(username, timestart, timestop);
    }


    static String greeting(){
        Scanner scgreeting = new Scanner(System.in);
        String username;
        System.out.println(">>Welcome to the Heap Sort test driver!");
        System.out.println(">>Hope you're doing well.");
        System.out.println(">>This program will test the heap sort algorithm");
        System.out.print(">>Please enter your name: ");
        username = scgreeting.nextLine();
        divline();
        return username;
    }

    static void farewell(String username, long timestart, long time){
        divline();
        System.out.println(">>User: "+username);
        elapsedtime(timestart);
    }

    static void divline(){
        System.out.println("################################################");
    }

    static void elapsedtime(long timestart){
        long timenow;
        long timeelaps;
        timenow = System.currentTimeMillis();
        timeelaps = timenow - timestart;
        System.out.println(">>Time elapsed: "+timeelaps+"ms");
    }
}
