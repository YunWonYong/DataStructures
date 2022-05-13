package linkedLists.single.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class AddTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void addTest() {
		Object value = 1;
		int inputIndex = 0;
		singlyLinkedList.add(value, inputIndex);
		assertEquals(value, singlyLinkedList.get(inputIndex));
	}
	
	@Test
	public void oneHundredAddTest() {
		try {
			int index = 0;
			int lastIndex = 100;
			while(true) {
				singlyLinkedList.add(++index);
				if (index == lastIndex) {
					assertEquals(lastIndex, singlyLinkedList.get(lastIndex - 1));
					break;
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void oneThousand() {
		try {
			int index = 0;
			int lastIndex = 1000;
			while(true) {
				singlyLinkedList.add(++index);
				if (index == lastIndex) {
					assertEquals(lastIndex, singlyLinkedList.get(lastIndex - 1));
					break;
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
