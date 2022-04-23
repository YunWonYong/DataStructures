package stack;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		int range = 100;
		while(true) {
			if (index < range) {
				stack.push(++index);
				continue;
			}
			
			if (stack.isEmpty()) {
				break;
			} 
			System.out.println(stack.pop());
		}
		
		Stack<int[]> stack2 = new Stack<>();
		stack2.push(new int[] {1, 2});
		stack2.push(new int[] {2, 3});
		stack2.push(new int[] {3, 4});
		stack2.push(new int[] {4, 5});
		
		int[] array = null;
		while ((array = stack2.pop()) != null) {
			System.out.println(Arrays.toString(array));
		}
		
		index = 0;
		range = 10;
		Stack2<Integer> stack3 = new Stack2<>();
		while(true) {
			if (index < range) {
				stack3.push(++index);
				continue;
			}
			
			if (stack3.isEmpty()) {
				break;
			} 
			System.out.println(stack3.pop());
		}
		
	}

}
