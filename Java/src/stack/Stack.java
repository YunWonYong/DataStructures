package stack;

public class Stack<T> {
	private T[] array;
	private int top;
	private int capacity;
	private final int DEFAULT_CAPCITY = 10;

	public Stack() {
		capacity = DEFAULT_CAPCITY;
		this.array = getArray();
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.array = getArray();
	}

	public boolean push(T element) {
		try {
			if (top == capacity) {
				extend();
			}
			array[top++] = element;
		} catch (Exception e) {
			return false;

		}
		return true;
	}
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T t = top();
		top--;
		return t;
	}
	
	public T top() {
		return isEmpty() ? null : array[top - 1];
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
 
	public void extend() {
		T[] temp = array;
		array = getArray();
		System.arraycopy(array, 0, temp, 0, temp.length);
//		int index = 0;
//		int range = temp.length;
//		while(index < range) {
//			array[index] = temp[index++];
//		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] getArray() { 
		capacity *= capacity;
		T[] array = (T[]) new Object[capacity];
		return array;
	}

}
