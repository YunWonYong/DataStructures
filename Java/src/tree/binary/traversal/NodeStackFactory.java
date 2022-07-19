package tree.binary.traversal;

import stack.Stack2;
import tree.binary.Node;

class NodeStackFactory<E> {
	private Stack2<Node<E>> stack;
	NodeStackFactory() {
	}
	
	Stack2<Node<E>> instance() {
		return instance(10, null);
	}
	
	Stack2<Node<E>> instance(Node<E> root) {
		return instance(10, root);
	}
	
	Stack2<Node<E>>instance(int capacity, Node<E> root) {
		stack = new Stack2<Node<E>>(capacity);
		if (root != null) {
			stack.push(root);			
		}
		return stack;
	}
	
	Node<E> top() {
		return stack.top();
	}
	
	Node<E> pop() {
		return stack.pop();
	}
	
	@SuppressWarnings("unchecked")
	void notNullNodePush(Object ...objs) {
		int index = 0;
		int range = objs.length;
		Object obj = null;
		while(index < range) {
			obj = objs[index++];
			if (obj == null || !(obj instanceof Node<?>)) {
				continue;
			}
			stack.push((Node<E>)obj);	
		}
	}
}
