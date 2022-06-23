package tree.binary.traversal;

import tree.binary.Node;

public class TreeRecursiveTraversal<E> extends AbstractTreeTraversal<E> {
	
	public TreeRecursiveTraversal() {
		super();
	}

	@Override
	public void preOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		buffer.append(node.getData()).append(", ");
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}

	@Override
	public void inOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeftChild());
		buffer.append(node.getData()).append(", ");
		inOrder(node.getRightChild());
	}

	@Override
	public void postOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		buffer.append(node.getData()).append(", ");
	}
}
