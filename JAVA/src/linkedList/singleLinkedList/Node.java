package linkedList.singleLinkedList;
class Node<T> {
	T data;
	Node<T> next;
	
	private Node() {}
	
	Node(T data) {
		this();
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		Node<T> temp = null;
		if (obj instanceof Node) {
			temp = (Node<T>) obj;
			if ((data == null && temp.data == null) || data.equals(temp.data)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return new StringBuffer().append("current: ").append(data).append(", next: ").
				append(next == null ? null : next.data).toString();
	}
}
