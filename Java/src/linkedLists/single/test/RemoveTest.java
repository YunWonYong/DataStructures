package linkedLists.single.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class RemoveTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void headRemoveTest() {
		singlyLinkedList.add(1);
		assertTrue(singlyLinkedList.remove(0));
	}
	
	@Test
	public void tailRemoveTest() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		assertTrue(singlyLinkedList.remove(1));
	}
	
	@Test
	public void tailRemoveTest2() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		assertTrue(singlyLinkedList.remove(3));
		assertTrue(singlyLinkedList.remove(2));
		assertTrue(singlyLinkedList.remove(1));
	}
	
	@Test
	public void allRemoveTest() {
		singlyLinkedList.add(1);
		singlyLinkedList.add(2);
		singlyLinkedList.add(3);
		singlyLinkedList.add(4);
		assertTrue(singlyLinkedList.remove(3));
		assertTrue(singlyLinkedList.remove(2));
		assertTrue(singlyLinkedList.remove(1));
		assertTrue(singlyLinkedList.remove(0));
		assertNull(singlyLinkedList.get(0));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFailIndexOutOfBoundsExceptionTest1() {
		try {
			singlyLinkedList.remove(1);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFailIndexOutOfBoundsExceptionTest2() {
		try {
			singlyLinkedList.remove(-1);
		} catch (Exception e) {
			throw e;
		}
	}
}
