package linkedLists.circular.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import linkedLists.circular.CircularLinkedList;


public class PushTest {
	private CircularLinkedList<String> circularLinkedList = null;
	
	@Before
	public void setUp() {
		circularLinkedList = new CircularLinkedList<>();
	}
	
	@Test
	public void putTest() {
		circularLinkedList.push("안");
		circularLinkedList.push("녕");
		circularLinkedList.push("하");
		circularLinkedList.push("세");
		circularLinkedList.push("요");
		Object[] array = circularLinkedList.toArray();
		StringBuffer sb = new StringBuffer();
		for (Object el: array) {
			sb.append(el.toString());
		}
		assertEquals(sb.toString(), "안녕하세요", sb.toString());
		assertNotEquals(sb.toString(), "안녕하세요!", sb.toString());
	}

	@Test
	public void put2Test() {
		circularLinkedList.push("안");
		Object[] array = circularLinkedList.toArray();
		StringBuffer sb = new StringBuffer();
		for (Object el: array) {
			sb.append(el.toString());
		}
		assertEquals(sb.toString(), "안", sb.toString());
		assertNotEquals(sb.toString(), "안녕하세요!", sb.toString());
	}
}
