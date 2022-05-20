package linkedLists.circular.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedLists.circular.CircularLinkedList;

public class GetTest {
	private CircularLinkedList<String> circularLinkedList = null;
	
	@Before
	public void setUp() {
		circularLinkedList = new CircularLinkedList<>();
	}
	
	@Test
	public void getFirstTest() {
		circularLinkedList.push("A");
		String first = circularLinkedList.getFirst();
		assertEquals("A", first);
	}
	
	@Test
	public void getLastTest() {
		circularLinkedList.push("A");
		String last = circularLinkedList.getLast();
		assertEquals("A", last);
	}
	
	@Test
	public void firstEqualsLastTest() {
		circularLinkedList.push("A");
		circularLinkedList.push("B");
		String first = circularLinkedList.getFirst();
		String last = circularLinkedList.getLast();
		assertNotEquals("B", first);
		assertNotEquals("A", last);
		assertEquals("A", first);
		assertEquals("B", last);
	}
	
	@Test
	public void getTest() {
		circularLinkedList.push("A");
		circularLinkedList.push("B");
		String firstElement = circularLinkedList.get(0);
		String lastElement = circularLinkedList.get(1);
		assertEquals("A", firstElement);
		assertEquals("B", lastElement);
	}
	
	@Test
	public void getIndexTest() {
		circularLinkedList.push("A");
		circularLinkedList.push("B");
		circularLinkedList.push("C");
		circularLinkedList.push("D");
		int aElement = circularLinkedList.getIndex("A");
		int bElement = circularLinkedList.getIndex("B");
		int cElement = circularLinkedList.getIndex("C");
		int dElement = circularLinkedList.getIndex("D");
		int eElement = circularLinkedList.getIndex("E");
		assertTrue(aElement == 0);
		assertTrue(bElement == 1);
		assertTrue(cElement == 2);
		assertTrue(dElement == 3);
		assertFalse(eElement == 4);
		assertTrue(eElement == -1);
	}
	
	@Test
	public void integerElementGetIndexTest() {
		CircularLinkedList<Integer> circularLinkedList2 = new CircularLinkedList<Integer>(); 
		circularLinkedList2.push(1);
		circularLinkedList2.push(2);
		circularLinkedList2.push(3);
		circularLinkedList2.push(4);
		int element1 = circularLinkedList2.getIndex(1);
		int element2 = circularLinkedList2.getIndex(2);
		int element3 = circularLinkedList2.getIndex(3);
		int element4 = circularLinkedList2.getIndex(4);
		int element5 = circularLinkedList2.getIndex(5);
		assertTrue(element1 == 0);
		assertTrue(element2 == 1);
		assertTrue(element3 == 2);
		assertTrue(element4 == 3);
		assertFalse(element5 == 4);
		assertTrue(element5 == -1);
	}
}
