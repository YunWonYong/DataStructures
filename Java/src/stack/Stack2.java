package stack;

import list.List;

public class Stack2<T> {
	private List<T> array;
	private int top;

	public Stack2() {
		this(10);
	}
	
	public Stack2(int capacity) {
		this.array = new List<>(capacity);
	}

	public boolean push(T element) {
		try {
			array.add(element);
			top++;
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
		return isEmpty() ? null : array.get(top - 1);
	}
	
	public boolean isEmpty() {
		return top == 0;
	}

}
