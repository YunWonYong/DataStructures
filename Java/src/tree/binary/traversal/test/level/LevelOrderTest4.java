package tree.binary.traversal.test.level;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.binary.Node;
import tree.binary.traversal.LevelOrder;

public class LevelOrderTest4 {
	private static final Node<Integer> ROOT_NODE = new Node<>(null, 3, null);
	private static final LevelOrder<Integer> LEVEL_ORDER = new LevelOrder<Integer>();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Node<Integer> leftChildNode = new Node<>(new Node<>(null, 1, null), 2, null);
		Node<Integer> rightChildNode = new Node<>(new Node<>(null, 4, null), 5, null);
		ROOT_NODE.setLeftChild(leftChildNode);
		ROOT_NODE.setRightChild(rightChildNode);
	}	
	
	@Test
	public void levelOrderTest() {
		LEVEL_ORDER.traversal(ROOT_NODE);
		assertEquals("3, 2, 5, 1, 4", LEVEL_ORDER.flush());
	}
}
