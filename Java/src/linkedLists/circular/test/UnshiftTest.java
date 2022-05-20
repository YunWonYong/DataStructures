package linkedLists.circular.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import linkedLists.circular.CircularLinkedList;

public class UnshiftTest {
	private CircularLinkedList<String> circularLinkedList = null;
	
	@Before
	public void setUp() {
		circularLinkedList = new CircularLinkedList<>();
	}
	
	@Test
	public void unshiftTest() {
		circularLinkedList.unshift("안");
		circularLinkedList.unshift("녕");
		circularLinkedList.unshift("하");
		circularLinkedList.unshift("세");
		circularLinkedList.unshift("요");
		Object[] array = circularLinkedList.toArray();
		StringBuffer sb = new StringBuffer();
		for (Object el: array) {
			sb.append(el.toString());
		}
		assertNotEquals(sb.toString(), "안녕하세요", sb.toString());
		assertEquals(sb.toString(), "요세하녕안", sb.toString());
	}

	@Test
	public void unshift2Test() {
		circularLinkedList.unshift("안");
		Object[] array = circularLinkedList.toArray();
		StringBuffer sb = new StringBuffer();
		for (Object el: array) {
			sb.append(el.toString());
		}
		assertEquals(sb.toString(), "안", sb.toString());
		assertNotEquals(sb.toString(), "안녕하세요!", sb.toString());
	}
}
