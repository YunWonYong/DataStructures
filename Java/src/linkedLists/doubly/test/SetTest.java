package linkedLists.doubly.test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;

public class SetTest {
	private DoublyLinkedList<String> doublyLinkedList;
	
	@Before
	public void setUp() {
		doublyLinkedList = new DoublyLinkedList<String>();
	}

	@Test
	public void setTest() {
		String[] array = new String[] {"안", "녕", "하", "세", "요"};
		String[] except = new String[] {"안", "녕", "히", "시", "오?"};
		doublyLinkedList.addAll(array);
		assertEquals("하", doublyLinkedList.set(2, "히"));
		assertEquals("세", doublyLinkedList.set(3, "시"));
		assertEquals("요", doublyLinkedList.set(4, "오?"));
		assertArrayEquals(except, doublyLinkedList.toArray());
	}

	@Test
	public void headNodeSetTest() {
		String[] array = new String[] {"안", "녕", "하", "세", "요"};
		String[] except = new String[] {"아", "녕", "하", "세", "요"};
		doublyLinkedList.addAll(array);
		assertEquals("안", doublyLinkedList.set(0, "아"));
		assertArrayEquals(except, doublyLinkedList.toArray());
	}

	@Test
	public void tailNodeSetTest() {
		String[] array = new String[] {"안", "녕", "하", "세", "요"};
		String[] except = new String[] {"안", "녕", "하", "세", "용"};
		doublyLinkedList.addAll(array);
		assertEquals("요", doublyLinkedList.set(doublyLinkedList.size() - 1, "용"));
		assertArrayEquals(except, doublyLinkedList.toArray());
	}
}
