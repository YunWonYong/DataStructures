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
			printBufferDataPush(currentNode)
				.notNullNodePush(callStack, currentNode.getRightChild(), currentNode.getLeftChild());
		}
	}

	@Override
	public void inOrder(Node<E> node) {
		final Stack2<Node<E>> callStack = STACK_FACTORY.getInstance(node);
		Node<E> currentNode = null;
		Node<E> leftNode = null;
		while(true) {
			currentNode = callStack.pop();
			leftNode = currentNode.getLeftChild(); 
			if (isNull(leftNode)) {
				printBufferDataPush(currentNode);
				currentNode = callStack.pop();
				if (isNull(currentNode)) {
					return;
				}
				
				printBufferDataPush(currentNode)
					.notNullNodePush(callStack, currentNode.getRightChild());
				continue;
			}
			notNullNodePush(callStack, currentNode, leftNode);
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
			leftChildNode = currentNode.getLeftChild();
			rightChildNode = currentNode.getRightChild();
			if (leftChildNode == null && rightChildNode == null) {
				printBufferDataPush(currentNode);
				parentNode = callStack.top();
				if (parentNode == null) {
					return;
				}		
			} else if (currentNode.equals(parentNode)) {
				if (rightChildNode != null) {
					callStack.push(leftChildNode);
					continue;
				}
				
			}
			
			if (leftChildNode != null) {
				callStack.push(leftChildNode);
				continue;
			}
			
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
	
	private TreeIterativeTraversal<E> printBufferDataPush(Node<E> node) {
		printBufferDataPush(node, ", ");
		return this;
	}
	
	private void printBufferDataPush(Node<E> node, String separator) {
		bufferAppend(node.getData(), separator);
	}
}
