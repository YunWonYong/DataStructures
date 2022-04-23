package queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		int index = 0;
		int range = 10;
		Integer element = 0;
		while(true) {
			if (index < range) {
				queue.enqueue(++index);
				continue;
			}
			element = queue.dequeue();
			if (element == null) {
				System.out.println("끝");
				return;
			}
			System.out.println(element);
			
		}
	}

}
