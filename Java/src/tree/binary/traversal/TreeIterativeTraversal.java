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
		Map<Integer, Boolean> printTable = new HashMap<Integer, Boolean>();
		Node<E> currentNode = null;
		Node<E> parentNode = null;
		Boolean printFlag = false;
		int key = 0_0;
		while(true) {
			currentNode = callStack.top();
			key = parentNode != null ? parentNode.hashCode(): currentNode.hashCode();
			printFlag = printTable.get(key);
			if (printFlag != null && printFlag == true) {
				printBufferDataPush(currentNode);
				callStack.pop();
				parentNode = callStack.top();
				key = parentNode != null ? parentNode.hashCode(): currentNode.hashCode();
				if (parentNode != null && parentNode.getLeftChild().equals(currentNode)) {
					printTable.put(key, false);
					notNullNodePush(callStack, parentNode.getRightChild());
				} else if (parentNode != null && parentNode.getRightChild().equals(currentNode)) {
					printTable.put(key, true);
				} else if (parentNode == null) {
					return;
				}
				continue;
			} else if (printFlag == null || printFlag == false) {
				
				if (isChildrenNull(currentNode)) {
					callStack.pop();
					if (parentNode != null && parentNode.getLeftChild().equals(currentNode)) {
						printTable.put(key, false);
						notNullNodePush(callStack, parentNode.getRightChild());
					} else if (parentNode != null && parentNode.getRightChild().equals(currentNode)) {
						printTable.put(key, true);
						parentNode = null;
					} 
					printBufferDataPush(currentNode);
					continue;
				}
//				 if (printFlag != null && printFlag == false) {
//					notNullNodePush(callStack, parentNode.getRightChild());
//					continue;
//				}
			}
			parentNode = currentNode;	
			notNullNodePush(callStack, currentNode.getLeftChild());
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
