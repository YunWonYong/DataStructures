package linkedLists.single.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class AddIndexTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void zeroAddIndexTest() {
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		singlyLinkedList.add(5);
		try {
			Object value = 1;
			int inputIndex = 0;
			singlyLinkedList.add(value, inputIndex);
			assertEquals(value, singlyLinkedList.get(inputIndex));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = Exception.class)
	public void addIndexFailTest1() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		try {
			singlyLinkedList.add(0, -1);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(expected = Exception.class)
	public void addIndexFailTest2() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		try {
			singlyLinkedList.add(4, 5);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test
	public void lastAddIndexTest() {
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
