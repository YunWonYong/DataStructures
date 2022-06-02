package linkedLists.doubly.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;
public class RemoveTest {
    private DoublyLinkedList<String> doublyLinkedList = null;
    private static String[] EXCEPT;
    
    @BeforeClass
    public static void init() {
        EXCEPT = new String[]{"안", "녕", "하", "세", "요"};
    }

    @Before 
    public void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void emptyRemoveTest() {
        doublyLinkedList.remove(0);
    }

    @Test
    public void removeTest() {
        doublyLinkedList.addAll(EXCEPT);
        int size = doublyLinkedList.size();
        assertTrue(EXCEPT.length == size);
        while(--size > -1) {
            doublyLinkedList.remove(size);
        }

        assertTrue(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 0);
    }

    @Test
    public void removeTest2() {
        doublyLinkedList.addAll(EXCEPT);
        int size = doublyLinkedList.size();
        assertTrue(EXCEPT.length == size);
        while(--size > -1) {
            doublyLinkedList.remove(0);
        }

        assertTrue(doublyLinkedList.isEmpty());
        assertTrue(doublyLinkedList.size() == 0);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void removeTest3() {
        doublyLinkedList.addAll(EXCEPT);
        int size = doublyLinkedList.size();
        assertTrue(EXCEPT.length == size);
        int index = 0;
        while(index < size) {
            doublyLinkedList.remove(index++);
        }

    }

    @Test
    public void removeTest4() {
        doublyLinkedList.addAll(EXCEPT);
        int size = doublyLinkedList.size();
        assertTrue(EXCEPT.length == size);
        doublyLinkedList.remove(1);
        doublyLinkedList.remove(1);
        doublyLinkedList.remove(1);
        Object[] except = new Object[]{"안", "요"};
        assertArrayEquals(except, doublyLinkedList.toArray());
    }
}
