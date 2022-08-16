package tree.heap.version1;
public class MaxHeap<E> extends AbstractHeap<E> {
    public MaxHeap() {
        super();
    }

	@Override
	protected boolean compare(int left, int right) {
		return left < right;
	}
}
