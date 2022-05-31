package linkedLists.doubly;


public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private final NodeFactory factory;
	
	public DoublyLinkedList() {
		factory = NodeFactory.getInstance();
	}
	
	public void add(E value) {
		Node<E> node = null;
		size++;
		if (isFirst()) {
			node = factory.nodeInstance(value);
			this.head = node;
			return;
		} else if (isLast()) {
			node = factory.nodeInstance(head, value);
			head.setNext(node);
		} else {
			node = factory.nodeInstance(tail, value);
			tail.setNext(node);
		}
		tail = node;
	}

//	private Node<E> nodeInstance(E value) {
//		this.head = factory.nodeInstance(value);
//		return isFirst() ? factory.nodeInstance(value) 
//				: isLast() ? factory.nodeInstance(head, value)
//						: factory.nodeInstance(tail,value);
//	}
	
	
	public Object[] toArray() {
		Object[] array = new Object[size];
		Node<E> node = head;
		int index = 0;
		while(node != null) {
			array[index++] = node.getValue();
			node = node.getNext();
		}
		return array;
	}
	
	
	private boolean isFirst() {
		return this.head == null;
	}
	
	private boolean isLast() {
		return this.tail == null;
	}
}
