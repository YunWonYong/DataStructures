package linkedLists.single;

import java.util.Objects;

import linkedLists.LinkedListInterface;

public class SinglyLinkedList<T> implements LinkedListInterface<T> {
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

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public SinglyLinkedList() {}

	@Override
	public void add(T element) {
		Node<T> node = new Node<T>(element, null);
		if (this.head == null) {
			this.head = node;
		} else if (this.tail == null) {
			this.tail = node;
			this.head.next = tail;
		} else if (this.head != null && this.tail != null) {
			this.tail.next = node;
			this.tail = node;
		} 
		
		size++;
	}

	@Override
	public void add(T element, int index) {
		if (size < index) {
			try {
				throw new Exception(String.format("list size: %d add index: %d", size, index));
			} catch (Exception e) {
			}
		} else  if (size == index) {
			add(element);
			return;
		} 
		
		Node<T> node = new Node<>(element, null);
		if (index == 0) {
			node.next = this.head;
			this.head = node;
		} else {
			Node<T> prevNode = getNode(index - 1);
			Node<T> nextNode = prevNode.next;
			node.next = nextNode;
			prevNode.next = node;
		}
		
		size++;
	}

	@Override
	public T get(int index) {
		Node<T> node = getNode(index);
		return node == null ? null: node.value;
	}

	@Override
	public T set(T element, int index) {
		Node<T> node = getNode(index);
		if (node == null) {
			return null;			
		}
		T oldValue = node.value;
		node.value = element;
		return oldValue;
	}

	@Override
	public boolean remove(int index) {
		if (index < 0 || index >= this.size) {
			try {
				throw new IndexOutOfBoundsException(index);
			} catch (Exception e) {
				throw e;
			}
		} else if (index == 0) {
			this.head = null;
		} else if (indexCheck(--index)) {
			Node<T> node = getNode(index); 
			if(node.next.hashCode() == this.tail.hashCode()) {
				this.tail = node;
				node = null;
				this.tail.next = node;
				if (this.head.hashCode() == this.tail.hashCode()) {
					this.tail = null;
				}
			}
			
			if (node != null) {
				node.next = node.next.next;
			}
		} 
		size--;
		return true;
	}

	@Override
	public int indexOf(T element) {
		if (size > -1) {
			int index = 0;
			Node<T> node = this.head;
			do { 
				if(node.value.equals(element)) {
					return index;
				}
				index++;
			} while((node = node.next) != null);
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}
	
	private Node<T> getNode(int index) {
		if (indexCheck(index)) {
			return size == 0 ? this.head: size == index ? this.tail : findNode(index);
		}
		return null;
	}
	
	private Node<T> findNode(int index) {
		Node<T> node = null;
		int index2 = 0;
		node = this.head;
		while (true) {
			if (index == index2++) {
				return node;
			}
			node = node.next;
		}
	}
	
	private boolean indexCheck(int index) {
		return index > -1 && this.size > index;
	}
}
