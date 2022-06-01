package linkedLists.doubly;

class Node<E> {
	private Node<E> prev;
	private Node<E> next;
	private E value;
	
	Node(Node<E> prev, Node<E> next, E value) {
		this.prev = prev;
		this.value = value;
		this.next = next;
	}
	
	public Node<E> getPrev() {
		return this.prev;
	}
	
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	
	public Node<E> getNext() {
		return this.next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public E getValue() {
		return this.value;
	}
	
	public String toString() {
		return new StringBuffer()
		           .append("value: ")
				   .append(value)
				   .append(", prevNode: ")
				   .append(prev == null ? null: prev.value)
				   .append(", nextValue: ")
				   .append(next == null ? null: next.value)
				   .toString();
	}
}

public final class NodeFactory {
	private static NodeFactory INSTANCE;
	
	private NodeFactory() {
		
	}

	public static NodeFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new NodeFactory(); 
		}
		return INSTANCE;
	}
	
	public <E> Node<E> nodeInstance(E value) {
		return createNode(null, null, value);
	}
	
	public <E> Node<E> nodeInstance(E value, Node<E> next) {
		return createNode(null, next, value);
	}
	
	public <E> Node<E> nodeInstance(Node<E> prev, E value) {
		return createNode(prev, null, value);
	}
	
	public <E> Node<E> nodeInstance(Node<E> prev, Node<E> next, E value) {
		return createNode(prev, next, value);
	}

	private <E> Node<E> createNode(Node<E> prev, Node<E> next, E value) {
		return new Node<E>(prev, next, value);
	}

	
}
