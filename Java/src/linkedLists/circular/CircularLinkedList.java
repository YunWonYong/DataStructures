package linkedLists.circular;

import java.util.Objects;


public class CircularLinkedList<T> {
	@SuppressWarnings("hiding")
	private class Node<T> {
		private T value;
		private Node<T> next;

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(next, value);
			return result;
		}

		@Override
		public String toString() {
			StringBuffer state = new StringBuffer("value: ").append(value);
			if (next == null) {
				state.append("  next: null");
			} else {
				state.append("  nextNode:[hash: ")
			         .append(next.hashCode())
			         .append(", value: ")
			         .append(next.value)
			         .append("]");
			}
	       
			return state.toString();
		}
	}
	private Node<T> tail;
	private int size;

	public CircularLinkedList() {}
	
	public void push(T value) {
		Node<T> node = new Node<T>(value, null);
		size++;
		if (tail == null) {
			tail = node;
			tail.next = node;
			return;
		}
		Node<T> preNode = tail.next;
		tail.next = node;
		node.next = preNode;
		tail = node;
	}

	
	public void unshift(T value) {
		Node<T> node = new Node<T>(value, null);
		size++;
		if (tail == null) {
			tail = node;
			tail.next = node;
			return;
		}
		node.next = tail.next;
		tail.next = node;
	}
	
	public T pop() {
		if (tail == null) {
			return null;
		}

		Node<T> node = getPrevNode(tail);
		T value = tail.value;
		node.next = tail.next;
		tail = node;
		size--;
		if (size == 0) {
			tail = null;
		}
		return value;
	}
	
	public T shift() {
		if (tail == null) {
			return null;
		}
		Node<T> node = tail.next;
		T value = node.value;
		size--;
		if (size == 0) {
			tail = null;
		} else {
			tail.next = node.next;
		}
		return value;
	}
	
	public T get(int index) {
		T value = null;
		try {
			if (size < index || 0 > index) {
				throw new Exception(String.format("list size: %d, input index: %d", size, index));
			}
			int move = 0;
			Node<T> node = tail.next;
			while (true) {
				if (move == index) {
					value = node.value;
					break;
				} 
				node = node.next;
				move++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public T getLast() {
		return tail.value;
	}
	
	public T getFirst() {
		return tail.next.value;
	}

	public int getIndex(T value) {
		Node<T> current = tail.next;
		int index = 0;
		while(index < size) {
			if (valueCheck(value, current.value)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}
	
	public Object[] toArray() {
		Node<T> node = this.tail.next;
		final Object[] result = new Object[size];
		int index = 0;
		while (index < size) {
			result[index++] = node.value;
			node = node.next;
		}

		return result;
	}
	
	private Node<T> getPrevNode(Node<T> node) {
		Node<T> prevNode = node.next;
		while(!prevNode.next.equals(node)) {
			prevNode = prevNode.next;
		}
		return prevNode;
	}
	
//	private Node<T> getNode(T value) {
//		Node<T> current = tail.next;
//		int index = 0;
//		while(index < size) {
//			if (valueCheck(value, current.value)) {
//				return current;
//			}
//			current = current.next;
//		}
//		return current;
//	}
	
	private boolean valueCheck(T left, T right) {
		return (left == null && left == right) || left.equals(right);
	}
}
