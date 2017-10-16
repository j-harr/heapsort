
/**
 * This is the Heap class. Creates a heap object. Includes
 * constructors and the functions: deleteMin(), insert(), grow(), heapsort()
 * and buildHeap()
 */
public class Heap<AnyType extends Comparable<AnyType>>
{
    private static final int CAPACITY = 2;
    private int size;       //Number of elements in heap
    private AnyType[] heap; //The heap array

    /**
     * Heap()
     * Default Constructor
     */
    public Heap(){
        size = 0;
        heap = (AnyType[]) new Comparable[CAPACITY];
    }

    /**
     * Heap(AnyType[] arrayA)
     * Parametrized Constructor
     */
    public Heap(AnyType[] arrayA){
        size = arrayA.length;
        heap = (AnyType[]) new Comparable[arrayA.length+1];
        System.arraycopy(arrayA,0, heap, 1, arrayA.length);
        buildHeap();
    }

    /**
     * buildHeap()
     */
    private void buildHeap(){
        for(int k = size/2; k > 0; k--){
            percolateDown(k);
        }
    }

    /**
     * percolateDown()
     */
    private void percolateDown(int k){
        AnyType tmp = heap[k];
        int child;

        for(; 2*k <= size; k=child){
            child = 2*k;

            if(child != size &&
                    heap[child].compareTo(heap[child + 1]) > 0) child++;

            if(tmp.compareTo(heap[child]) > 0) heap[k] = heap[child];
            else
                break;
        }
        heap[k] = tmp;
    }

    /**
     * heapSort()
     */
    public void heapSort(AnyType[] array){
        size = array.length;
        heap = (AnyType[]) new Comparable[size+1];
        System.arraycopy(array, 0, heap, 1, size);
        buildHeap();

        for (int i = size; i > 0; i--){
            AnyType tmp = heap[i];
            heap[i] = heap[1];
            heap[1] = tmp;
            size--;
            percolateDown(1);
        }
        for(int k = 0; k < heap.length-1; k++)
            array[k] = heap[heap.length - 1 - k];
    }

    /**
     * deleteMin()
     */
    public AnyType deleteMin() throws RuntimeException{
        if (size == 0) throw new RuntimeException();
        AnyType min = heap[1];
        heap[1] = heap[size--];
        percolateDown(1);
        return min;
    }

    /**
     * insert(AnyType x)
     */
    public void insert(AnyType x){
        if(size == heap.length - 1) doubleSize();

        //Insert a new item to the end of the array
        int pos = ++size;

        //Percolate up
        for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2)
            heap[pos] = heap[pos/2];
        heap[pos] = x;
    }

    /**
     * doubleSize()
     */
    private void doubleSize(){
        AnyType [] old = heap;
        heap = (AnyType []) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    /**
     * toString()
     */
    public String toString(){
        String out = "";
        for(int k = 1; k <= size; k++) out += heap[k]+" ";
        return out;
    }

}
