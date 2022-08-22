package tree.heap.version1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import tree.heap.Heap;

public class Main {

    public static void main(String[] args) {
    	List<List<Integer>> lists = new ArrayList<>();
    	Scanner sc = new Scanner(System.in);
    	int index = 0;
    	do {
    		lists.add(getRandomList());
    	} while(++index < 10);
        System.out.println("max start");
        lists.forEach(list -> {
            Heap<Integer> maxHeap = new MaxHeap<>();
            Queue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
            System.out.println("oldData");
            System.out.println(Arrays.toString(list.toArray()));
        	list.forEach( el -> {
        		maxHeap.add(el);   
        		priority.add(el);
        	}); 
        	System.out.println("custom max heap");
        	System.out.println(maxHeap.print());
        	System.out.println("api max heap");
        	System.out.println(priority.toString());
        	StringBuffer sb1 = new StringBuffer();
        	StringBuffer sb2 = new StringBuffer();
        	while (maxHeap.isEmpty() == false) {
        		sb1.append(maxHeap.remove()).append(", ");
        		sb2.append(priority.remove()).append(", ");
        	}
        	System.out.println("sort max heap");
        	System.out.println(sb1.toString());
        	System.out.println("api max heap");
        	System.out.println(sb2.toString());
        	System.out.println("next enter");
        	sc.nextLine();
        });
        
        System.out.println("min start");
        lists.forEach(list -> {
            Heap<Integer> minHeap = new MinHeap<>();
            Queue<Integer> priority = new PriorityQueue<>();
            System.out.println("oldData");
            System.out.println(Arrays.toString(list.toArray()));
        	list.forEach( el -> {
        		minHeap.add(el);   
        		priority.add(el);
        	}); 
        	System.out.println("custom min heap");
        	System.out.println(minHeap.print());
        	System.out.println("api min heap");
        	System.out.println(priority.toString());
        	StringBuffer sb1 = new StringBuffer();
        	StringBuffer sb2 = new StringBuffer();
        	while (minHeap.isEmpty() == false) {
        		sb1.append(minHeap.remove()).append(", ");
        		sb2.append(priority.remove()).append(", ");
        	}
        	System.out.println("sort min heap");
        	System.out.println(sb1.toString());
        	System.out.println("api max heap");
        	System.out.println(sb2.toString());
        	System.out.println("next enter");
        	sc.nextLine();
        });
        System.out.println("print end");
        sc.close();
    } 
    
    public static List<Integer> getRandomList() {
    	List<Integer> list = new ArrayList<>();
    	int index = 0;
    	do {
    		list.add(genRandomNumber());
    	} while(++index < 20);    	
    	return list;
    }
    
    public static Integer genRandomNumber() {
    	return (int) Math.floor(Math.random() * 10000 + 1);
    }
}