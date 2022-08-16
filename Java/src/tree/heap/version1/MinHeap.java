package tree.heap.version1;
public class MinHeap<E> extends AbstractHeap<E> {
    public MinHeap() {
        super();
    }

	@Override
	protected boolean compare(int left, int right) {
		return left > right;
	}
    
}
