package tree.binary.traversal;

import tree.binary.Node;

public interface TreeTraversal<E> {
	public void preOrder(Node<E> node);
	public void inOrder(Node<E> node);
	public void postOrder(Node<E> node);
}
