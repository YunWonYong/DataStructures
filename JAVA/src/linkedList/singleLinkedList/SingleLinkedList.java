package linkedList.singleLinkedList;

import linkedList.LinkedList;

public class SingleLinkedList<T> implements LinkedList<T> {
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public SingleLinkedList() {
	}

	@Override
	public int add(T value) {
		Node<T> newNode = null;
		try {
			newNode = new Node<T>(value);
			if (this.head == null) {
				this.head = newNode;
			} else {
				if (this.tail == null) {
					this.head.next = newNode;
				} else {
					this.tail.next = newNode;
				}
				this.tail = newNode;
			}
			this.size++;
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int set(int index, T value) {
		return -1;
	}

	@Override
	public int remove(int index) {

		return -1;
	}

	@Override
	public boolean remove(Object value) {
		Node<T> node = null;
		T temp = null;
		if (this.size > 0) {
			if (this.head != null) {
				node = this.head;
				temp = node.data;
				if ((temp == null && value == null) || temp.equals(value)) {
				}
			}
		}
		return false;
	}

	@Override
	public int indexOf(T value) {
		return -1;
	}

	@Override
	public T get(int index) {
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void nodePrint() {
		Node<T> node = this.head;
		StringBuffer sb = new StringBuffer(node.toString()).append("\n");
		while((node = node.next) != null) {
			sb.append(node.toString()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
