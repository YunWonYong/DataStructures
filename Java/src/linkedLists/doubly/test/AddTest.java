package linkedLists.doubly.test;


import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;

public class AddTest {
	private DoublyLinkedList<Integer> doublyLinkedList;
	
	@Before
	public void setUp() {
		doublyLinkedList = new DoublyLinkedList<Integer>();
	}
	
	@Test
	public void addTest() {
		int index = 0;
		int range = 10;
		while(index++ < range) {
			doublyLinkedList.add(index);
		}
		
		Object[] except = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(except, doublyLinkedList.toArray());
	}

}
