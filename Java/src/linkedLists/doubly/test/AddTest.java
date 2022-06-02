package linkedLists.doubly.test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

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

	@Test
	public void arrayAddAllTest() {
		Integer[] array = new Integer[] {100, 120, 130, 212, 12314, 1231515, 123125};
		doublyLinkedList.addAll(array);
		assertTrue(doublyLinkedList.size() == array.length);
		assertArrayEquals(array, doublyLinkedList.toArray());
	}

	@Test
	public void collectionsAddAllTest() {
		Integer[] except = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> list = Arrays.asList(except);

		doublyLinkedList.addAll(list);
		assertTrue(doublyLinkedList.size() == list.size());
		assertArrayEquals(list.toArray(), doublyLinkedList.toArray());
	}
}
