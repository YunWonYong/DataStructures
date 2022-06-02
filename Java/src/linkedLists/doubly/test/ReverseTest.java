package linkedLists.doubly.test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;

public class ReverseTest {

	@Test
	public void reverseTest() {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
		List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		doublyLinkedList.addAll(array);
		doublyLinkedList.reverse();
		Collections.reverse(array);
		assertArrayEquals(array.toArray(), doublyLinkedList.toArray());
	}

	@Test
	public void reverseTest2() {
		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("가", "나", "다", "라", "마", "바", "사"));
		doublyLinkedList.addAll(list);
		doublyLinkedList.reverse();
		Collections.reverse(list);
		assertArrayEquals(list.toArray(), doublyLinkedList.toArray());
		assertEquals(list.get(0), doublyLinkedList.get(0));
		int size = list.size();
		assertEquals(list.get(size - 1), doublyLinkedList.get(size - 1));
		list.add("ㄱ");
		doublyLinkedList.add("ㄱ");
		assertArrayEquals(list.toArray(), doublyLinkedList.toArray());
	}
}
