import java.util.*;

public class Heap<AnyType extends Comparable<AnyType>>
{
    private static final int CAPACITY = 2;
    private int size;       //Number of elements in heap
    private AnyType[] heap; //The heap array

    public Heap(){
        size = 0;
        heap = (AnyType[]) new Comparable[CAPACITY];
    }

    public Heap(AnyType[] arrayA){
        size = arrayA.length;
        heap = (AnyType[]) new Comparable[arrayA.length+1];
        System.arraycopy(arrayA,0, heap, 1, arrayA.length);
        buildHeap();
    }

}
