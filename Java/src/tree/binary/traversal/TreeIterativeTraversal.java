package tree.binary.traversal;

import java.util.HashMap;
import java.util.Map;

import tree.binary.Node;

public class TreeIterativeTraversal<E> extends AbstractTreeTraversal<E> {
	private final NodeStackFactory<E> STACK_FACTORY = new NodeStackFactory<E>();
	public TreeIterativeTraversal() {
	}
	
	@Override
	public void preOrder(Node<E> node) {		
		STACK_FACTORY.instance(node);
		Node<E> currentNode = null;
		while(isNotNull(currentNode = STACK_FACTORY.pop())) {
			printBufferDataPush(currentNode);
			STACK_FACTORY.notNullNodePush(currentNode.getRightChild(), currentNode.getLeftChild());
		}
	}

	@Override
	public void inOrder(Node<E> node) {
		STACK_FACTORY.instance(node);
		Node<E> currentNode = node;
		while(true) {
			if (isNotNull(currentNode)) {
				STACK_FACTORY.notNullNodePush(currentNode.getLeftChild());
				currentNode = currentNode.getLeftChild();
				continue;
			}
			currentNode = STACK_FACTORY.pop();
			if (isNull(currentNode)) {
				return;
			}
			printBufferDataPush(currentNode);
			currentNode = currentNode.getRightChild();
			STACK_FACTORY.notNullNodePush(currentNode);
		}
	}

	@Override
	public void postOrder(Node<E> node) {
		STACK_FACTORY.instance();
		Map<Integer, Boolean> visitor = new HashMap<>();
		Node<E> currentNode =  node;
		Boolean childrenPrintCheck = null;
		int key = 0_0;
		while(true) {
			if (isNotNull(currentNode)) {
				STACK_FACTORY.notNullNodePush(currentNode);
				visitor.put(currentNode.hashCode(), false);
				currentNode = currentNode.getLeftChild();
				continue;
			}
			
			currentNode = STACK_FACTORY.top();
			if (currentNode == null) {
				break;
			}
			key = currentNode.hashCode();
			childrenPrintCheck = visitor.get(key);
			if (isNotNull(childrenPrintCheck) && childrenPrintCheck == true) {
				STACK_FACTORY.pop();
				printBufferDataPush(currentNode);
				visitor.put(key, true);
				currentNode = null;
				continue;
			}
			
			currentNode = currentNode.getRightChild();
			
			if (isNull(currentNode)) {
				visitor.put(key, true);
				continue;
			} 

			childrenPrintCheck = visitor.get(currentNode.hashCode());
			if (isNotNull(childrenPrintCheck) && childrenPrintCheck == true) {
				currentNode = null;
				visitor.put(key, true);
			}
			
		}
	}
	
	
	private boolean isNotNull(Object node) {
		return isNull(node) == false;
	}
	
	private boolean isNull(Object node) {
		return node == null;
	}
	
	private void printBufferDataPush(Node<E> node) {
		printBufferDataPush(node, ", ");
	}
	
	private void printBufferDataPush(Node<E> node, String separator) {
		bufferAppend(node.getData(), separator);
	}
}
