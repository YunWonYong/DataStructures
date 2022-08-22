package tree.heap.version1;
public class MinHeap<E> extends AbstractHeap<E> {
    public MinHeap() {
        super();
    }

	@Override
	protected boolean compare(E left, E right) {
		Integer leftEl = parseInt(left);
		Integer rightEl = parseInt(right);
		if (leftEl == null || rightEl == null) {
			return false;
		}
		return leftEl > rightEl;
	}
    
}
