package tree.heap.version1;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Heap<Integer> maxHeap = new MaxHeap<>();
        List<Integer> dataList = Arrays.asList(3, 2, 4, 5, 7, 8, 9, 1, 6, 10, 15, 11, 12, 13, 14);
        dataList.forEach(maxHeap::add);
        System.out.println(maxHeap.print());
        StringBuffer sb = new StringBuffer();
        while(!maxHeap.isEmpty()) {
        	sb.append(maxHeap.remove()).append(", ");
        }
        System.out.println(sb.toString());
        
        Heap<Integer> minHeap = new MinHeap<>();
        dataList.forEach(minHeap::add);
        System.out.println(minHeap.print());
        sb.setLength(0);
        while(!minHeap.isEmpty()) {
        	sb.append(minHeap.remove()).append(", ");
        }
        System.out.println(sb.toString());
    }
}