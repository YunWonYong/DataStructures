package tree.heap.version1;
import java.util.Arrays;

import tree.heap.Heap;

public abstract class  AbstractHeap<E> implements Heap<E> {
    protected E[] array;
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
        E currentEl = null;
        while(true) {
        	currentEl = getEl(currentIndex);
        	if (currentEl == null) {
        		return removeEl;        		
        	}
        	leftChildIndex = getLeftChildIndex(currentIndex);
        	E left = getEl(leftChildIndex);
        	if (left == null){
        		return removeEl;
        	}
        	
        	rightChildIndex = getRightChildIndex(currentIndex);
        	E right = getEl(rightChildIndex);
        	int swapIndex = leftChildIndex;
        	
        	if (left != null && right != null) {
    			swapIndex = compare(left, right)? rightChildIndex: leftChildIndex;
        	} 
        	
        	currentIndex = swapCheck(currentIndex, swapIndex)? swapIndex: currentIndex + 1;
        }
    }
    
    public boolean isEmpty() {
    	return array[0] == null;
    }
    
    public String print() {
    	StringBuffer sb = new StringBuffer().append("[");
    	int index = 0;
    	while(true) {
    		sb.append(array[index++]);
    		if (index == size) {
    			return sb.append("]").toString();
    		}
    		sb.append(", ");
    	}
    }
    
    protected Integer parseInt(E el) {
    	return isInt(el) ? (Integer) el: null;
    }
    
    protected abstract boolean compare(E left, E right);

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
            if (!indexCheck(checkIndex)) {
            	return;
            }
            
            if (swapCheck(checkIndex, index)) {
            	index = checkIndex;
                continue;
            }
            
            checkIndex = getLeftChildIndex(index);
            
            if (indexCheck(checkIndex) && swapCheck(index, checkIndex)) {
            	index = checkIndex;
                continue;
            }
            
            checkIndex = getRightChildIndex(index);
            
            if (indexCheck(checkIndex) && swapCheck(index, checkIndex)) {
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
    
    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }
    
    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }
    
    private E getEl(int index) {
    	return indexCheck(index)? array[index]: null;
    }
    
    private boolean indexCheck(int index) {
    	return this.size > index && index > -1;
    }

    private boolean swapCheck(int leftIndex, int rightIndex) {
        E leftEl = getEl(leftIndex);
        E rightEl = getEl(rightIndex);
        if (leftEl == null || rightEl == null || !compare(leftEl, rightEl)) {
        	return false;
        }
        
        swap(leftIndex, rightIndex);
        return true;
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