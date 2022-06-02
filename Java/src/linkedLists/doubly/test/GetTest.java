package linkedLists.doubly.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import linkedLists.doubly.DoublyLinkedList;

public class GetTest {

    @Test 
    public void getTest() {
        String[] array = new String[]{"더", "블", "링", "크", "드", "리", "스", "트"};
        DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();
        stringDoublyLinkedList.addAll(array);
        assertEquals(stringDoublyLinkedList.get(0), array[0]);
        assertEquals(stringDoublyLinkedList.get(stringDoublyLinkedList.size() - 1), array[array.length - 1]);

    }

    @Test 
    public void getTest2() {
        List<String> list = Arrays.asList("가", "나", "다", "라", "마", "바", "사", "가");
        DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();
        stringDoublyLinkedList.addAll(list);
        int index = 0;
        int range = stringDoublyLinkedList.size();
        while(index < range) {
            assertEquals(list.get(index), stringDoublyLinkedList.get(index++));
        }
    }
}
