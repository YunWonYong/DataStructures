import java.util.Arrays;

class Nodee<T> {
	Nodee<T> preNode;
	T value;
	Nodee<T> nextNode;
	public Nodee(T value) {
		this.value = value;
	}
}

class DoubleLinkedList<T> {
	Nodee<T> head;
	Nodee<T> tail;
	
	public void add(T value) {

		Nodee<T> node = new Nodee<T>(value);
		if(head == null) {
			head = node;
			return;
		} else if (tail == null) {
			tail = node;
			tail.preNode = head;
			tail.nextNode = head;
			head.preNode = tail;
			head.nextNode = tail;
			return;
		}
		Nodee<T> temp = head.nextNode;
		while(true) {
			if (temp.equals(tail)) {
				temp.nextNode = node;
				node.preNode = temp;
				node.nextNode = head;
				tail = node;
				return;
			}
			temp = temp.nextNode;
		}
	}
	
	public void print() {
		StringBuffer sb = new StringBuffer();
		Nodee<T> node = head;
		while(node != null) {
			sb.append(node.value).append(" ");
			node = node.nextNode;
			if (head.equals(node)) {
				System.out.println(sb.toString());
				return;
			}
		}
	}
}

public class Main {
	static int cap;
	public static void main(String[] args) {
		int[] arr = new int[20];
		int index = 0;
		int range = 20;
		while(index < range) {
			arr[index] = range - ++index;
					//(int)(Math.random() * 100);
		}
		
		arr[arr.length - 1] = 100;
		
		System.out.println("踰꾨툝 �젙�젹");
		int[] bubbleSortArr = bubbleSort(arr.clone());
		System.out.println(Arrays.toString(bubbleSortArr));
		System.out.println("�궫�엯 �젙�젹");
		int[] insertSortArr = insertSort(arr.clone());
		System.out.println(Arrays.toString(insertSortArr));
		System.out.println("�씠吏� �깘�깋");
		System.out.println(binarySearch(insertSortArr, 13)); 
		System.out.println(binarySearch(insertSortArr, 20)); // -1
		System.out.println(binarySearch(insertSortArr, 0)); // -1
		System.out.println(binarySearch(insertSortArr, 1)); // 0
		System.out.println(binarySearch(insertSortArr, 100)); // 19
	}
	
	private static int binarySearch(int[] arr, int target) {
		int low = 0;
		int heigh = arr.length - 1;
		int mid = heigh / 2;
		int temp = 0;
		while(true) {
			temp = arr[mid];
			if(temp == target) {
				return mid;
			} else if (temp < target) {
				low = mid + 1;
			} else if (temp > target) {
				heigh = mid - 1;
			}
			
			mid = (low + heigh) / 2;
			
			if (low > mid || mid > heigh) {
				return -1;
			}
		}
	}
	
	private static int[] insertSort(int[] clone) {
		int[] temp = new int[clone.length];
		int tempN = 0;
		int index = 0;
		int index2 = 0;
		temp[index] = clone[index++];
		int range = clone.length;
		boolean swap = true;
		while(index < range) {
			if (temp[index - 1] < clone[index]) {
				temp[index] = clone[index++];
				continue;
			}
			temp[index] = clone[index];
			index2 = index;
			swap = false;
			while(!swap) {
				if (temp[index2 - 1] < temp[index2]) {
					swap = true;
					continue;
				}
				tempN = temp[index2 - 1];
				temp[index2 - 1] = temp[index2];
				temp[index2] = tempN;
				index2 -= index2 > 1 ? 1 : 0;
			}
			index++;
		}
		return temp;
	}

	private static int[] bubbleSort(int[] clone) {
		int index = 0;
		int currentElement = 0;
		int range = clone.length - 1;
		boolean bubbleFlag = true;
		while(bubbleFlag) {
			bubbleFlag = false;
			while(index < range) {
				currentElement = clone[index];
				if (currentElement > clone[index + 1]) {
					clone[index] = clone[index + 1];
					clone[index + 1] = currentElement;
					bubbleFlag = true;
				}
				index++;
			}
			range--;
			index = 0;
		}
		return clone;
	}
}
