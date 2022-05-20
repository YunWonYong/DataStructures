package linkedLists.circular.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import linkedLists.circular.CircularLinkedList;

public class PopTest {
	private CircularLinkedList<String> circularLinkedList = null;
	
	@Before
	public void setUp() {
		circularLinkedList = new CircularLinkedList<>();
	}
	
	@Test
	public void popTest() {
		circularLinkedList.push("안");
		circularLinkedList.push("녕");
		circularLinkedList.push("하");
		circularLinkedList.push("세");
		circularLinkedList.push("요");
		StringBuffer sb = new StringBuffer();
		sb.append(circularLinkedList.pop())
		  .append(circularLinkedList.pop())
		  .append(circularLinkedList.pop())
		  .append(circularLinkedList.pop())
		  .append(circularLinkedList.pop());
		assertNotEquals(sb.toString(), "안녕하세요", sb.toString());
		assertEquals(sb.toString(), "요세하녕안", sb.toString());
		assertTrue(circularLinkedList.pop() == null);
	}

}
