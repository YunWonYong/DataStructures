package linkedList;

import linkedList.singleLinkedList.SingleLinkedList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> singleLinked = new SingleLinkedList<Integer>();
		singleLinked.add(1);
		singleLinked.add(2);
		singleLinked.add(3);
		singleLinked.add(4);
		singleLinked.add(5);
		singleLinked.add(6);
		singleLinked.add(7);
		singleLinked.nodePrint();
	}

}
