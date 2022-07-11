package tree.binary.traversal.test.recursive;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.binary.Node;
import tree.binary.traversal.TreeRecursiveTraversal;

public class RecursiveTraversalTest3 {
	private static final Node<Integer> ROOT_NODE = new Node<>(null, 3, null);
	private static final TreeRecursiveTraversal<Integer> RECURSIVE_TRAVERSAL = new TreeRecursiveTraversal<Integer>();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Node<Integer> leftChildNode = new Node<>(new Node<>(null, 1, null), 2, null);
		Node<Integer> rightChildNode = new Node<>(null, 4, new Node<>(null, 5, null));
		ROOT_NODE.setLeftChild(leftChildNode);
		ROOT_NODE.setRightChild(rightChildNode);
		
	}	
	
	@Test
	public void recursivePreOrderTraversal() {
		RECURSIVE_TRAVERSAL.preOrder(ROOT_NODE);
		assertEquals("3, 2, 1, 4, 5", RECURSIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void recursiveInOrderTraversal() {
		RECURSIVE_TRAVERSAL.inOrder(ROOT_NODE);
		assertEquals("1, 2, 3, 4, 5", RECURSIVE_TRAVERSAL.flush());
	}
	
	@Test
	public void recursivePostOrderTraversal() {
		RECURSIVE_TRAVERSAL.postOrder(ROOT_NODE);
		assertEquals("1, 2, 5, 4, 3", RECURSIVE_TRAVERSAL.flush());
	}

}
