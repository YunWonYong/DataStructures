package linkedLists.single.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class GetTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void getTest() {
		singlyLinkedList.add(1, 0);
		singlyLinkedList.add(2, 1);
		assertEquals(1, singlyLinkedList.get(0));
		assertEquals(2, singlyLinkedList.get(1));
	}
	
	@Test
	public void getFailTest() {
		assertNull(singlyLinkedList.get(0));
	}
}
