package tree.heap.version1;
public interface Heap<E> {
    public abstract void add(E element);
    public abstract E remove();
    public abstract boolean isEmpty();
    public abstract String print();
}