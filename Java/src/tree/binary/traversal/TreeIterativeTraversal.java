package tree.binary.traversal;

import stack.Stack2;
import tree.binary.Node;

public class TreeIterativeTraversal<E> extends AbstractTreeTraversal<E> {
	private final NodeStackFactory<E> STACK_FACTORY = new NodeStackFactory<E>();
	public TreeIterativeTraversal() {
	}
	
	@Override
	public void preOrder(Node<E> node) {		
		final Stack2<Node<E>> callStack = STACK_FACTORY.getInstance(node);
		Node<E> currentNode = null;
		while((currentNode = callStack.pop()) != null) {
			printBufferDataPush(currentNode);
			notNullNodePush(callStack, currentNode.getRightChild(), currentNode.getLeftChild());
		}
	}

	@Override
	public void inOrder(Node<E> node) {
		final Stack2<Node<E>> callStack = STACK_FACTORY.getInstance(node);
		Node<E> currentNode = null;
		Node<E> pushChildNode = null;
		while(true) {
			currentNode = callStack.top();
			pushChildNode = currentNode.getLeftChild();
			if (isNull(pushChildNode)) {
				
				printBufferDataPush(currentNode);
				callStack.pop();
				currentNode = callStack.pop();
				if (isNull(currentNode)) {
					return;
				}
				
				printBufferDataPush(currentNode);
				pushChildNode = currentNode.getRightChild();
			}
			
			notNullNodePush(callStack, pushChildNode);
		}
	}

	@Override
	public void postOrder(Node<E> node) {
		final Stack2<Node<E>> callStack = STACK_FACTORY.getInstance(node);
		Node<E> currentNode = null;
		Node<E> leftChildNode = null;
		Node<E> rightChildNode = null;
		Node<E> parentNode = null;
		while(true) {
			currentNode = callStack.pop();
			if (isChildrenNull(currentNode)) {
			}
			return;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void notNullNodePush(Stack2<Node<E>> stack, Object ...objs) {
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
 	
	private boolean isChildrenNull(Node<E> parentNode) {
		return isLeftChildNull(parentNode) && isRightChildNull(parentNode);
	}
	
	private boolean isLeftChildNull(Node<E> parentNode) {
		return isNull(parentNode.getLeftChild());
	}
	
	private boolean isRightChildNull(Node<E> parentNode) {
		return isNull(parentNode.getRightChild());
	}
	
	private boolean isNull(Node<E> node) {
		return node == null;
	}
	
	private void printBufferDataPush(Node<E> node) {
		printBufferDataPush(node, ", ");
	}
	
	private void printBufferDataPush(Node<E> node, String separator) {
		bufferAppend(node.getData(), separator);
	}
}
