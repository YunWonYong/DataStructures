package linkedLists.single.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class SetTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void setTest() {
		Object oldValue = 2;
		singlyLinkedList.add(oldValue);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		try {
			Object value = 1;
			int testIndex = 0;
			assertEquals(oldValue, singlyLinkedList.set(value, testIndex));
			assertEquals(value, singlyLinkedList.get(testIndex));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void setFailTest() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		try {
			Object value = 5;
			int inputIndex = 4;
			singlyLinkedList.add(value, inputIndex);
			assertEquals(value, singlyLinkedList.get(inputIndex));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
