package tree.heap.version1.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.BeforeClass;
import org.junit.Test;

import tree.heap.Heap;
import tree.heap.version1.MaxHeap;
import tree.heap.version1.MinHeap;

public class HeapTest {
	private final static List<List<Integer>> TEST_CASE_LIST = new ArrayList<>();
	
	@BeforeClass 
	public static void setup() {
		List<Integer> list = null;
    	do {
    		list = new ArrayList<>();
    		while(list.size() < 10000) {
    			list.add((int) Math.floor(Math.random() * 10000 + 1));
    		}
    		TEST_CASE_LIST.add(list);
    	} while(TEST_CASE_LIST.size() < 10);
	}
	
	@Test
	public void maxHeapTest() {
		TEST_CASE_LIST.forEach(list -> {
			Heap<Integer> heap = new MaxHeap<>();
            Queue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
            list.forEach(el -> {
            	heap.add(el);
            	priority.add(el);
            });
            assertEquals(heap.print(), priority.toString());
            
            while(!heap.isEmpty()) {
            	assertEquals(heap.remove(), priority.remove());
            }
		});
	}

	@Test
	public void minHeapTest() {
		TEST_CASE_LIST.forEach(list -> {
			Heap<Integer> heap = new MinHeap<>();
            Queue<Integer> priority = new PriorityQueue<>();
            list.forEach(el -> {
            	heap.add(el);
            	priority.add(el);
            });
            assertEquals(heap.print(), priority.toString());
            
            while(!heap.isEmpty()) {
            	assertEquals(heap.remove(), priority.remove());
            }
		});
	}
	
}
