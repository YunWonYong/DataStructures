package tree.binary.traversal;

import tree.binary.Node;

public abstract class AbstractTreeTraversal<E> implements TreeTraversal<E> {

	protected StringBuffer buffer;
	
	protected AbstractTreeTraversal() {
		buffer = new StringBuffer();
	}

	public String flush() {
		String str = buffer.toString();
		if (str.length() > 2) {
			str = str.substring(0, str.length() - 2);			
		}
		buffer.setLength(0);
		return str;
	}
	
	protected void bufferAppend(E data, String separator) {
		buffer.append(data).append(separator);
	}
	
	@Override
	public abstract void preOrder(Node<E> node);

	@Override
	public abstract void inOrder(Node<E> node);

	@Override
	public abstract void postOrder(Node<E> node);

}
