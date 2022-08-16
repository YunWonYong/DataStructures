package tree.binary.traversal.test.level;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.binary.Node;
import tree.binary.traversal.LevelOrder;

public class LevelOrderTest {
	private static final Node<Integer> ROOT_NODE = new Node<>(null, 8, null);
	private static final LevelOrder<Integer> LEVEL_ORDER = new LevelOrder<Integer>();
	
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
	public void levelOrderTest() {
		LEVEL_ORDER.traversal(ROOT_NODE);
		assertEquals("8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15", LEVEL_ORDER.flush());
	}
}
