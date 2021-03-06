package tree.binary.traversal.test.recursive;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.binary.Node;
import tree.binary.traversal.TreeRecursiveTraversal;

public class RecursiveTraversalTest {
	private static final Node<Integer> ROOT_NODE = new Node<>(null, 8, null);
	private static final TreeRecursiveTraversal<Integer> RECURSIVE_TRAVERSAL = new TreeRecursiveTraversal<Integer>();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Node<Integer> leftChildNode = new Node<>(null, 1, null);
		Node<Integer> rightChildNode = new Node<>(null, 3, null);
		Node<Integer> parentNode = new Node<>(leftChildNode, 2, rightChildNode);
		Node<Integer> tempNode = parentNode;
		
		leftChildNode = new Node<>(null, 5, null);
		rightChildNode = new Node<>(null, 7, null);
		parentNode = new Node<>(leftChildNode, 6, rightChildNode);
		
		leftChildNode = tempNode;
		rightChildNode = parentNode;
		ROOT_NODE.setLeftChild(new Node<>(leftChildNode, 4, rightChildNode));
		
		
		leftChildNode = new Node<>(null, 9, null);
		rightChildNode = new Node<>(null, 11, null);
		parentNode = new Node<>(leftChildNode, 10, rightChildNode);
		
		tempNode = parentNode;
		
		leftChildNode = new Node<>(null, 13, null);
		rightChildNode = new Node<>(null, 15, null);
		parentNode = new Node<>(leftChildNode, 14, rightChildNode);
		
		leftChildNode = tempNode;
		rightChildNode = parentNode;		
		ROOT_NODE.setRightChild(new Node<>(leftChildNode, 12, rightChildNode));
		
	}	
	
	@Test
	public void recursivePreOrderTraversal() {
		RECURSIVE_TRAVERSAL.preOrder(ROOT_NODE);
		assertEquals("8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15", RECURSIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void recursiveInOrderTraversal() {
		RECURSIVE_TRAVERSAL.inOrder(ROOT_NODE);
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15", RECURSIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void recursivePostOrderTraversal() {
		RECURSIVE_TRAVERSAL.postOrder(ROOT_NODE);
		assertEquals("1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8", RECURSIVE_TRAVERSAL.flush());
	}

}
