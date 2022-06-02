package linkedLists.doubly.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;

public class IndexOfsTest {

    @Test 
    public void indexOfTest() {
        DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();
        stringDoublyLinkedList.addAll(new String[]{"더", "블", "링", "크", "드", "리", "스", "트"});
        assertTrue(stringDoublyLinkedList.indexOf("더") == stringDoublyLinkedList.lastIndexOf("더"));
        assertTrue(stringDoublyLinkedList.indexOf("링") == stringDoublyLinkedList.lastIndexOf("링"));
        assertTrue(stringDoublyLinkedList.indexOf("트") == stringDoublyLinkedList.lastIndexOf("트"));

    }

    @Test 
    public void indexOfTest2() {
        DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();
        stringDoublyLinkedList.addAll(new String[]{"가", "나", "다", "라", "마", "바", "사", "가"});
        assertTrue(stringDoublyLinkedList.indexOf("가") == 0);
        assertTrue(stringDoublyLinkedList.lastIndexOf("가") == stringDoublyLinkedList.size() - 1);
        assertTrue(stringDoublyLinkedList.indexOf("나") == 1);
        assertTrue(stringDoublyLinkedList.lastIndexOf("나") == 1);
        assertTrue(stringDoublyLinkedList.lastIndexOf("하") == -1);
        assertTrue(stringDoublyLinkedList.lastIndexOf("아") == -1);
    }
}
