package tree.binary.traversal;

import java.util.HashMap;
import java.util.Map;

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
		Node<E> currentNode = node;
		while(true) {
			if (currentNode != null) {
				notNullNodePush(callStack, currentNode.getLeftChild());
				currentNode = currentNode.getLeftChild();
				continue;
			}
			currentNode = callStack.pop();
			if (currentNode == null) {
				return;
			}
			printBufferDataPush(currentNode);
			currentNode = currentNode.getRightChild();
			notNullNodePush(callStack, currentNode);
		}
	}

	@Override
	public void postOrder(Node<E> node) {
		final Stack2<Node<E>> callStack = STACK_FACTORY.getInstance(node);
		Map<Integer, Boolean> printTable = new HashMap<Integer, Boolean>();
		Node<E> currentNode = null;
		Node<E> parentNode = null;
		Node<E> pushChildNode = null;
		Boolean printFlag = false;
		
		int key = 0_0;
		while((currentNode = callStack.top()) != null) {
			key = parentNode != null ? parentNode.hashCode(): currentNode.hashCode();
			printFlag = printTable.get(key);
			if(printFlag != null && printFlag == true) {
				callStack.pop();
				printBufferDataPush(currentNode);
				parentNode = callStack.top();
				if (parentNode == null) {
					return;
				}
				
				key = parentNode.hashCode();
				
				if (currentNode.equals(parentNode.getLeftChild())) {
					printTable.put(key, false);
					notNullNodePush(callStack, parentNode.getRightChild());
				} else if (currentNode.equals(parentNode.getRightChild())) {
					printTable.put(key, true);
				}
				continue;
			} else if (isLeafNode(currentNode)) {
				callStack.pop();
				if (parentNode != null) {
					if (currentNode.equals(parentNode.getLeftChild())) {
						printTable.put(key, false);
					} 
					
					if (isRightChildNull(parentNode) || currentNode.equals(parentNode.getRightChild())) {
						printTable.put(key, true);
					} 
					
					if (!currentNode.equals(parentNode.getRightChild()) && isRightChildNull(parentNode) == false) {
						notNullNodePush(callStack, parentNode.getRightChild());
					}
				}
				printBufferDataPush(currentNode);
				continue;
			}
			if (isLeftChildNull(currentNode) == false) {
				pushChildNode = currentNode.getLeftChild();
			} else if (isRightChildNull(currentNode) == false) {
				pushChildNode = currentNode.getRightChild();
			}
			parentNode = currentNode;
			notNullNodePush(callStack, pushChildNode);
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

	private boolean isLeafNode(Node<E> node) {
		return isLeftChildNull(node) && isRightChildNull(node);
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
