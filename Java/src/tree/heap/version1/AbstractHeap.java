package version1;
import java.util.Arrays;

public abstract class  AbstractHeap<E> implements Heap<E> {
    private E[] array;
    private int size;
    private int currentIndex;
    private final boolean MIN_MAX_FLAG;
    
    protected AbstractHeap(boolean flag) {
        this(flag, 10);
    }

    protected AbstractHeap(boolean flag, int capacity) {
        MIN_MAX_FLAG = flag;
        grow(capacity);
    }


    public void add(E element) {
        if ( array.length == size ) {
            grow(array.length << 2);
        }
        array[size] = element;
        heapify(size++);
    }

    public E remove() {
        E removeEl = array[currentIndex++];
        return removeEl;
    }

    private void grow(int capacity) {
        if (array == null) {
            init(capacity);
            return;
        }
        array = Arrays.copyOf(array, capacity);
    }

    private void init(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private void heapify(int index) {
        int checkIndex = 0;
        while(index < size) {
            checkIndex = getParentIndex(index);
            if (swapCheck(checkIndex, index)) {
                continue;
            }
            checkIndex = getLeftChildIndex(index);
            if (swapCheck(checkIndex, index)) {
                continue;
            }
            checkIndex = getRightChildIndex(index);
            if (swapCheck(checkIndex, index)) {
                continue;
            }

            index++;
        }   
    }

    private int getParentIndex(int index) {
        return index <= 0 ? 0: index / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean swapCheck(int leftIndex, int rightIndex) {
        E leftEl = array[leftIndex];
        E rightEl = array[rightIndex];
        if (isInt(leftEl) && isInt(rightEl)) {
            int left = (Integer) leftEl;
            int right = (Integer) rightEl;
            if ( (MIN_MAX_FLAG && left < right) || (!MIN_MAX_FLAG && left > right)) {
                swap(leftIndex, rightIndex);
                return true;
            } 
        }
        return false;
    }

    private boolean isInt(E el) {
        return el instanceof Integer && el != null;
    }

    
    private void swap(int leftIndex, int rightIndex) {
        E old = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = old;
    }
}