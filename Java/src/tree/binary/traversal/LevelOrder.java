package tree.binary.traversal;

import queue.Queue;
import tree.binary.Node;

public class LevelOrder<E> extends AbstractTreeTraversal<E> {
	private Queue<Node<E>> queue;
	public LevelOrder() {
		queue = new Queue<>();
	}
	
	public void traversal(Node<E> node) {
		queue.enqueue(node);
		Node<E> currentNode = null;
		while((currentNode = queue.dequeue()) != null) {
			bufferAppend(currentNode.getData(), ", ");
			notNullNodePush(currentNode.getLeftChild(), currentNode.getRightChild());
		}
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
			queue.enqueue((Node<E>)obj);	
		}
	}
}
