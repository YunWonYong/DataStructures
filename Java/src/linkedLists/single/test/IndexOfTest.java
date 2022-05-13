package linkedLists.single.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import linkedLists.single.SinglyLinkedList;

public class IndexOfTest {
	private SinglyLinkedList<Object> singlyLinkedList;
	
	@Before
	public void setUp() {
		singlyLinkedList = new SinglyLinkedList<>(); 
	}
	
	@Test
	public void indexOfTest() {
		Object value = 1;
		singlyLinkedList.add(value);
		assertEquals(0, singlyLinkedList.indexOf(value));
	}
	
	@Test
	public void indexOfTest2() {
		try {
			int index = 0;
			int lastIndex = 100;
			while(true) {
				singlyLinkedList.add(++index);
				if (index == lastIndex) {
					assertEquals(lastIndex - 1, singlyLinkedList.indexOf(lastIndex));
					break;
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
