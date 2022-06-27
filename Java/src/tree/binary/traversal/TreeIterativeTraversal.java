package tree.binary.traversal;

import java.util.HashMap;
import java.util.Map;

import stack.Stack;
import tree.binary.Node;

public class TreeIterativeTraversal<E> extends AbstractTreeTraversal<E> {
	
	public TreeIterativeTraversal() {
	}
	
	@Override
	public void preOrder(Node<E> node) {		
		final Stack<Node<E>> callStack = new Stack<Node<E>>();
		callStack.push(node);
		Node<E> leftNode = null;
		Node<E> rightNode = null;
		Node<E> currentNode = null;
		while((currentNode = callStack.pop()) != null) {
			bufferAppend(currentNode.getData(), ", ");
			leftNode = currentNode.getLeftChild();       
			rightNode = currentNode.getRightChild();     
			if (rightNode != null) {
				callStack.push(rightNode);
			}
			
			if (leftNode != null) {
				callStack.push(leftNode);
			}
		}
	}

	@Override
	public void inOrder(Node<E> node) {
		final Stack<Node<E>> callStack = new Stack<Node<E>>();
		callStack.push(node);
		Node<E> currentNode = null;
		Node<E> leftNode = null;
		Node<E> rightNode = null;
		while(true) {
			currentNode = callStack.pop();
			leftNode = currentNode.getLeftChild(); 
			if (leftNode == null) {
				bufferAppend(currentNode.getData(), ", ");
				currentNode = callStack.pop();
				if (currentNode == null) {
					return;
				}
				bufferAppend(currentNode.getData(), ", ");
				rightNode = currentNode.getRightChild();
				if (rightNode != null) {
					callStack.push(rightNode);
				}
				continue;
			}
			callStack.push(currentNode);
			callStack.push(leftNode);
		}
	}

	@Override
	public void postOrder(Node<E> node) {
		final Stack<Node<E>> callStack = new Stack<Node<E>>();
		final Map<Integer, Boolean> table = new HashMap<>();
		callStack.push(node);
		Node<E> currentNode = null;
		Node<E> leftNode = null;
		Node<E> rightNode = null;
		while(true) {
			currentNode = callStack.pop();
			table.put(currentNode.hashCode(), false);
			leftNode = currentNode.getLeftChild(); 
			if (leftNode == null) {
				bufferAppend(currentNode.getData(), ", ");					
				table.put(currentNode.hashCode(), true);
				rightNode = currentNode.getRightChild();
				if (rightNode == null) {
					currentNode = callStack.pop();
					continue;
				}
				currentNode = rightNode;
				continue;
			}
			callStack.push(currentNode);
			callStack.push(leftNode);
		}
	}
}
