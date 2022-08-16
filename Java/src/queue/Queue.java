package queue;

public class Queue<T> {
	private T[] array;
	private int front;
	private int rear;
	private int capacity;
	private final static int DEFAULT_CAPCITY = 10;
	
	public Queue() {
		this(DEFAULT_CAPCITY);
	}
	
	public Queue(int capacity) {
		this.capacity = capacity;
		this.array = getArray(capacity);
	}
	
	public boolean enqueue(T element) {
		try {
			if (rear == capacity) {
				extend();
			}
			array[rear++] = element;
		} catch (Exception e) {
			return false;

		}
		return true;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			front = 0;
			rear = 0;
			return null;
		}
		return getElement();
	}
	
	private T getElement() {
		T element = array[front];
		array[front++] = null;
		return element;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void extend() {
		T[] temp = array;
		array = getArray(this.capacity * this.capacity);
//		System.arraycopy(array, 0, temp, 0, temp.length);
		int index = 0;
		int range = temp.length;
		while(index < range) {
			array[index] = temp[index++];
		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] getArray(int capacity) { 
		T[] array = (T[]) new Object[capacity];
		return array;
	}
}
