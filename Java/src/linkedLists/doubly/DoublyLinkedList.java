package linkedLists.doubly;

import java.util.Collection;

public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private final NodeFactory factory;
	
	public DoublyLinkedList() {
		this.factory = NodeFactory.getInstance();
	}
	
	public void add(E value) {
		Node<E> node = null;
		size++;
		if (isEmpty()) {
			node = factory.nodeInstance(value);
			this.head = node;
			return;
		} else if (isTailNodeNull()) {
			node = factory.nodeInstance(this.head, value);
			this.head.setNext(node);
		} else {
			node = factory.nodeInstance(this.tail, value);
			this.tail.setNext(node);
		}
		this.tail = node;
	}

	public void add(int index, E value) {
		try {
			if (index == size) {
				add(value);
				return;
			} 
			
			Node<E> oldNode = nodeIndexSearch(index);
			size++;
			Node<E> node = factory.nodeInstance(oldNode.getPrev(), value, oldNode);
			Node<E> prevNode = oldNode.getPrev();
			
			if (prevNode != null) {
				prevNode.setNext(node);
			} else if (index == 0) {
				this.head = node;
			} 
			
			oldNode.setPrev(node);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public void addAll(E[] values) {
		try {
			if (values == null) {
				throw new NullPointerException("input values is null");
			}
			int index = 0;
			int range = values.length;
			do {
				add(values[index]);
			} while(++index < range);
		} catch (Exception e) {
			throw e;
		}
	}

	public void addAll(Collection<? extends E> container) {
		try {

			if (container == null) {
				throw new NullPointerException("input values is null");
			}
			container.forEach(this::add);
		} catch (Exception e) {
			throw e;
		}
	}

	public E remove(int index) {
		Node<E> node = nodeIndexSearch(index);
		size--;
		E value = getValue(node);
		if (headNodeCheck(node)) {
			this.head = node.getNext();
			if (this.head == null) {
				return value;
			}
			this.head.setPrev(null);
			if (tailNodeCheck(this.head)) {
				this.tail = null;
			}
			return value;
		} else if (tailNodeCheck(node)) {
			this.tail = node.getPrev();
			this.tail.setNext(null);
			if (headNodeCheck(this.tail)) {
				this.tail = null;
			}
			return value;
		}
		Node<E> prevNode = node.getPrev();
		Node<E> nextNode = node.getNext();
		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		return value;
	}

	public int removeAll() {
		this.head = null;
		this.tail = null;
		return size = 0;
	}

	public E get(int index) {
		return getValue(nodeIndexSearch(index));
	}

	public E set(int index, E value) {
		Node<E> node = nodeIndexSearch(index);
		E oldValue = node.getValue();
		node.setValue(value);
		return oldValue;
	}

	public int indexOf(E value) {
		return nodeElementSearch(value, true);
	}

	public int lastIndexOf(E value) {
		return nodeElementSearch(value, false);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return isHeadNodeNull() && isTailNodeNull();
	}
	
	public Object[] toArray() {
		Object[] array = new Object[this.size];
		Node<E> node = head;
		int index = 0;
		while(node != null) {
			array[index++] = node.getValue();
			node = node.getNext();
		}
		return array;
	}

	public void reverse() {
		if (isEmpty() || isTailNodeNull()) {
			return;
		}
		this.head = this.tail;
		Node<E> node = this.head;
		Node<E> tempNode = null;
		while(true) {
			tempNode = node.getPrev();
			node.setPrev(node.getNext());
			node.setNext(tempNode);
			if (tempNode == null) {
				this.tail = node;
				return;
			}
			tempNode.setNext(tempNode.getPrev());
			tempNode.setPrev(node);
			node = tempNode.getNext();
		}
	}

	private boolean isHeadNodeNull() {
		return head == null;
	}

	private boolean isTailNodeNull() {
		return tail == null;
	}

	private boolean headNodeCheck(Node<E> node) {
		return isHeadNodeNull() ? false: this.head.equals(node);
	}

	private boolean tailNodeCheck(Node<E> node) {
		return isTailNodeNull() ? false: this.tail.equals(node);
	}

	private Node<E> nodeIndexSearch(int index) {
		try {
			if (!checkAvailableIndexe(index)) {
				throw new IndexOutOfBoundsException(String.format("size: %d, index: %d", size, index));
			}
			int range = size - 1;
			int mid = range / 2;
			return mid >= index? search(head, 0, mid, index, true): search(tail, range, mid, index, false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}

	private Node<E> search(Node<E> node, int from, int to, int index, boolean direction) {
		do {
			if (index == from) {
				return node;
			} else if (!direction) {
				from--;
				node = node.getPrev();
				continue;
			}
			from++;
			node = node.getNext();
		} while(direction ? from <= to : from >= to);
		return null;
	}
	
	private int nodeElementSearch(E value, boolean direction) {
		if (isEmpty()) {
			return -1;
		} else if (isTailNodeNull()) {
			return this.head.getValue().equals(value) ? 0 : -1;
		}
		return direction ? headNodeStartSearch(value): tailNodeStartSearch(value);
	}

	private int headNodeStartSearch(E value) {
		int pos = 0;
		Node<E> node = this.head;
		do {
			if (node.getValue().equals(value)) {
				return pos;
			}
			pos++;
		} while((node = node.getNext()) != null);
		return -1;
	}

	private int tailNodeStartSearch(E value) {
		int pos = this.size - 1;
		Node<E> node = this.tail;
		do {
			if (node.getValue().equals(value)) {
				return pos;
			}
			pos--;
		} while((node = node.getPrev()) != null);
		return -1;
	}

	private boolean checkAvailableIndexe(int index) {
		return size > index && index > -1;
	}

	private E getValue(Node<E> node) {
		return node == null ? null: node.getValue();
	}
}
