package tree.binary.traversal;

import tree.binary.Node;

public abstract class AbstractTreeTraversal<E> implements TreeTraversal<E> {

	protected StringBuffer buffer;
	
	protected AbstractTreeTraversal() {
		buffer = new StringBuffer();
	}

	public String flush() {
		String str = buffer.toString();
		str = str.substring(0, str.length() - 2);
		System.out.println(str);
		buffer.setLength(0);
		return str;
	}
	
	@Override
	public abstract void preOrder(Node<E> node);

	@Override
	public abstract void inOrder(Node<E> node);

	@Override
	public abstract void postOrder(Node<E> node);

}
