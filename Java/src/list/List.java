package list;

public class List<T> {
	private T[] array;
	private int size;
	private int capacity;
	private final int DEFAULT_CAPCITY = 10;

	public List() {
		capacity = DEFAULT_CAPCITY;
		this.array = getArray();
	}
	
	public List(int capacity) {
		this.capacity = capacity;
		this.array = getArray();
	}

	public boolean add(T element) {
		try {
			if (size == capacity) {
				extend();
			}
			array[size++] = element;
		} catch (Exception e) {
			return false;

		}
		return true;
	}
	
	public T get(int index) {
		if(isEmpty()) {
			return null;
		}
		if (size <= index) {
			return null;
		}
		return array[index];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
 
	public void extend() {
		T[] temp = array;
		array = getArray();
		System.arraycopy(array, 0, temp, 0, temp.length);
	}
	
	@SuppressWarnings("unchecked")
	private T[] getArray() { 
		capacity *= capacity;
		T[] array = (T[]) new Object[capacity];
		return array;
	}
}
