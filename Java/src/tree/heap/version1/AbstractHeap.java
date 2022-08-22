package tree.heap.version1;
import java.util.Arrays;

import tree.heap.Heap;

public abstract class  AbstractHeap<E> implements Heap<E> {
    private E[] array;
    private int size;
    
    protected AbstractHeap() {
        this(10);
    }

    protected AbstractHeap(int capacity) {
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
        E removeEl = array[0];
        array[0] = array[--size];
        array[size] = null;
        int currentIndex = 0;
        int leftChildIndex = 0;
        int rightChildIndex = 0;
        Integer currentEl = null;
        Integer leftChildEl = null;
        Integer rightChildEl = null;
        while(true) {
        	currentEl = parseInt(currentIndex);
        	if (currentEl == null) {
        		return removeEl;        		
        	}
        	leftChildIndex = getLeftChildIndex(currentIndex);
        	if (leftChildIndex >= array.length) {        		
        		leftChildEl = null;
        	} else {
        		leftChildEl = parseInt(leftChildIndex);        		
        	}
        	rightChildIndex = getRightChildIndex(currentIndex);
        	if (rightChildIndex >= array.length) {        		
        		rightChildEl = null;
        	} else {
        		rightChildEl = parseInt(rightChildIndex); 
        	}
        	
        	if (leftChildEl == null && rightChildEl == null) {
        		return removeEl;
        	}
        	if (rightChildEl != null && leftChildEl != null) {
        		if (compare(leftChildEl, rightChildEl) && compare(currentEl, rightChildEl)) {
        			swap(currentIndex, rightChildIndex);
        			currentIndex = rightChildIndex;
        			continue;
        		} else if (compare(currentEl, leftChildEl)) {
        			swap(currentIndex, leftChildIndex);
        			currentIndex = leftChildIndex;
        			continue;        		
        		}
        	} else if (leftChildEl == null && compare(currentEl, rightChildEl)) {
    			swap(currentIndex, rightChildIndex);
    			currentIndex = rightChildIndex;
    			continue;
    		} else if (rightChildEl == null && compare(currentEl, leftChildEl)) {
    			swap(currentIndex, leftChildIndex);
    			currentIndex = leftChildIndex;
    			continue;        			
    		}
        	
        	currentIndex++;
        }
    }
    
    public boolean isEmpty() {
    	return array[0] == null;
    }
    
    public String print() {
    	StringBuffer sb = new StringBuffer();
    	int index = 0;
    	while(true) {
    		sb.append(array[index++]);
    		if (index == size) {
    			return sb.toString();
    		}
    		sb.append(", ");
    	}
    }
    
    protected abstract boolean compare(int left, int right);

    private void grow(int capacity) {
        if (array == null) {
            init(capacity);
            return;
        }
        array = Arrays.copyOf(array, capacity);
    }

    @SuppressWarnings("unchecked")
	private void init(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private void heapify(int index) {
        int checkIndex = 0;
        while(index < size) {
            checkIndex = getParentIndex(index);
            if (swapCheck(checkIndex, index)) {
            	index = checkIndex;
                continue;
            }
            checkIndex = getLeftChildIndex(index);
            if (array.length > checkIndex && swapCheck(index, checkIndex)) {
            	index = checkIndex;
                continue;
            }
            checkIndex = getRightChildIndex(index);
            if (array.length > checkIndex && swapCheck(index, checkIndex)) {
            	index = checkIndex;
                continue;
            }

            index++;
        }   
    }

    private int getParentIndex(int index) {
    	index = index % 2 != 0 ? index / 2: index / 2 - 1;
        return index < 0? 0 : index;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean swapCheck(int leftIndex, int rightIndex) {
        Integer leftEl = parseInt(leftIndex);
        Integer rightEl = parseInt(rightIndex);
        if (leftEl != null && rightEl != null && compare(leftEl, rightEl)) {
        	swap(leftIndex, rightIndex);
        	return true;
        }
        return false;
    }
    
    private Integer parseInt(int index) {
    	E el = array[index];
    	return isInt(el) ? (Integer) el: null;
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