package tree.binary.traversal;

import stack.Stack2;
import tree.binary.Node;

class NodeStackFactory<E> {
	
	NodeStackFactory() {
	}
	
	Stack2<Node<E>> getInstance(Node<E> root) {
		return getInstance(10, root);
	}
	
	Stack2<Node<E>>getInstance(int capacity, Node<E> root) {
		Stack2<Node<E>> stack = new Stack2<Node<E>>(capacity);
		stack.push(root);
		return stack;
	}
}
