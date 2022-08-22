package tree.heap.version1;
public class MaxHeap<E> extends AbstractHeap<E> {
    public MaxHeap() {
        super();
    }

	@Override
	protected boolean compare(E left, E right) {
		Integer leftEl = parseInt(left);
		Integer rightEl = parseInt(right);
		if (leftEl == null || rightEl == null) {
			return false;
		}
		return leftEl < rightEl;
	}
}
