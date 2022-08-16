package version1;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        Heap<Integer> maxHeap = new MaxHeap<>();
        Arrays.asList(3, 2, 4, 5, 7, 8, 9, 1, 6, 10, 15, 11, 12, 13, 14).forEach(maxHeap::add);
    }
}