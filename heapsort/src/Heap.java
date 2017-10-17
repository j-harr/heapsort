
/**
 * This is the Heap class. Creates a heap object. Includes
 * constructors and the functions: deleteMin(), insert(), grow(), heapsort()
 * and buildHeap()
 */
public class Heap<T extends Comparable<T>>
{
    private static final int CAPACITY = 2;
    private int size;       //Number of elements in heap
    private T[] heap; //The heap array

    /**
     * Heap()
     * Default Constructor
     */
    public Heap()
    {
        size = 0;
        heap = (T[]) new Comparable[CAPACITY];
    }

    /**
     * buildHeap()
     */
    private void buildHeap()
    {
        for(int k = size/2; k > 0; k--){
            percolateDown(k);
        }
    }

    /**
     * percolateDown()
     */
    private void percolateDown(int k)
    {
        T tmp = heap[k];
        int child;

        for(; 2*k <= size; k=child){    //As long as k < (size/2)
            child = 2*k;                //Find child node
            if(child != size &&         //If child is not last and
                    heap[child].compareTo(heap[child + 1]) > 0) child++;
                                        //child is greater than its sibling
                                        //then get the sibling
            if(tmp.compareTo(heap[child]) > 0) heap[k] = heap[child];
                //If tmp is greater than the child, then parent = child
            else
                break;
        }
        heap[k] = tmp;
    }

    /**
     * heapSort()
     */
    public void heapSort(T[] array)
    {
        size = array.length;
        heap = (T[]) new Comparable[size+1];
        System.arraycopy(array, 0, heap, 1, size);
        buildHeap();

        for (int i = size; i > 0; i--){
            T tmp = heap[i];    //Last element in heap
            heap[i] = heap[1];  //Last elemment is equal to first element
            heap[1] = tmp;      //First element is now former last element
            size--;             //Decrement size
            percolateDown(1);
        }
        for(int k = 0; k < heap.length-1; k++)
            array[k] = heap[heap.length - 1 - k];
    }
}
