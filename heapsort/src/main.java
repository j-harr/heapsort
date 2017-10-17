/**
 * class Main
 * contains functions main(), greeting(), farewell(), divline(),
 * elapsedtime()
 * test()
 * serves as driver for testing heap and HeapSort functionality.
 */
import java.util.*;

public class Main {
    /**
     * main()
     * This function serves as the driver for testing the heapsort
     * functionality. The start time is recorded and the various tests are
     * implemented on the data. There are 9 different tests
     */
    public static void main(String [] args)
    {
        //DECLARATION OF VARIABLES
        long timestart;
        long timestop;

        //GREETING AND TIME START
        greeting();
        timestart = System.currentTimeMillis();
        System.out.println(">>Time Start: "+timestart);
        divline();

        //Time trials of various data sizes
        test(10000);
        test(20000);
        test(40000);
        test(80000);
        test(160000);
        test(320000);
        test(640000);
        test(1280000);
        test(2560000);

        //TIMESTOP AND FAREWELL
        timestop = System.currentTimeMillis();
        System.out.println(">>Time Stop: "+timestop);
        farewell(timestart);
    }


    private static void greeting()
    {
        Scanner scgreeting = new Scanner(System.in);
        String username;
        System.out.println(">>Welcome to the Heap Sort test driver!");
        System.out.println(">>Hope you're doing well.");
        System.out.println(">>This program will test the heap sort algorithm");
        System.out.print(">>Please enter your name: ");
        username = scgreeting.nextLine();
        divline();
        System.out.println(">>Current tester: "+username);
    }

    private static void farewell(long timestart)
    {
        divline();
        elapsedtime(timestart);
    }

    private static void divline()
    {
        System.out.println("################################################");
    }

    private static void elapsedtime(long timestart)
    {
        long timenow;
        long timeelaps;
        timenow = System.currentTimeMillis();
        timeelaps = timenow - timestart;
        System.out.println(">>Time elapsed: "+timeelaps+"ms");
    }

    private static void test(int size)
    {
        //Initialize variables
        Heap<Integer> tmp = new Heap<Integer>();
        Integer [] array01;
        array01 = new Integer[size];
        long timenow;

        //Start Timer and create array of data
        timenow = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            array01[(size-1) - i] = i;
        }

        //Print initial array
        System.out.println("Array size: "+size);
        System.out.print("Initial: ");
        System.out.print("{");
        for(int i = 0; i < size -1 && i < 19; i++){
            System.out.print(array01[i]+",");
        }
        if(size > 20){ System.out.println(array01[19]+"}");}
        else System.out.println(array01[size - 1]+"}");

        //Use HeapSort to sort the array
        tmp.heapSort(array01);

        //Print sorted array
        System.out.print("Sorted: ");
        System.out.print("{");
        for(int i = 0; i < size -1 && i < 19; i++){
            System.out.print(array01[i]+",");
        }
        if(size > 20){ System.out.println(array01[19]+"}");}
        else System.out.println(array01[size - 1]+"}");

        //Print elapsed time and dividing line
        elapsedtime(timenow);
        divline();
    }
}
