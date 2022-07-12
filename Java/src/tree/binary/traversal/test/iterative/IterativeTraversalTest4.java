package tree.binary.traversal.test.iterative;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.binary.Node;
import tree.binary.traversal.TreeIterativeTraversal;

public class IterativeTraversalTest4 {
	private static final Node<Integer> ROOT_NODE = new Node<>(null, 3, null);
	private static final TreeIterativeTraversal<Integer> ITERATIVE_TRAVERSAL = new TreeIterativeTraversal<Integer>();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Node<Integer> leftChildNode = new Node<>(new Node<>(null, 1, null), 2, null);
		Node<Integer> rightChildNode = new Node<>(new Node<>(null, 4, null), 5, null);
		ROOT_NODE.setLeftChild(leftChildNode);
		ROOT_NODE.setRightChild(rightChildNode);
		
	}	
	
	@Test
	public void iterativePreOrderTraversal() {
		ITERATIVE_TRAVERSAL.preOrder(ROOT_NODE);
		assertEquals("3, 2, 1, 5, 4", ITERATIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void iterativeInOrderTraversal() {
		ITERATIVE_TRAVERSAL.inOrder(ROOT_NODE);
		assertEquals("1, 2, 3, 4, 5", ITERATIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void iterativePostOrderTraversal() {
		ITERATIVE_TRAVERSAL.postOrder(ROOT_NODE);
		assertEquals("1, 2, 4, 5, 3", ITERATIVE_TRAVERSAL.flush());
	}

}
