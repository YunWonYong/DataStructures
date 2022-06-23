package tree.binary;

public class Node<E> {
	private Node<E> leftChild;
	private E data;
	private Node<E> rightChild;
	
	public Node(Node<E> leftChild, E data, Node<E> rightChild) {
		this.leftChild = leftChild;
		this.data = data;
		this.rightChild = rightChild;
	}

	public Node<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<E> leftChild) {
		this.leftChild = leftChild;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<E> rightChild) {
		this.rightChild = rightChild;
	}
	
}
