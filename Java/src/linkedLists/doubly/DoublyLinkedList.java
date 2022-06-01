package linkedLists.doubly;


public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private final NodeFactory factory;
	
	public DoublyLinkedList() {
		factory = NodeFactory.getInstance();
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
		Node<E> preNode = node.getPrev();
		Node<E> nextNode = node.getNext();
		//node.getPrev().setNext(node.getNext());
		preNode.setNext(nextNode);
		nextNode.setPrev(preNode);
		return value;
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
	
	private Node<E> nodeElementSearch(E value) {
		Node<E> node = null;
		return node;
	}

	private boolean checkAvailableIndexe(int index) {
		return size > index && index > -1;
	}

	private E getValue(Node<E> node) {
		return node == null ? null: node.getValue();
	}
}
