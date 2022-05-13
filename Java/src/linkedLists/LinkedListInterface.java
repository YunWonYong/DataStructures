package linkedLists;

public interface LinkedListInterface<T> {
	public abstract void add(T element);
	public abstract void add(T element, int index);
	public abstract T get(int index);
	public abstract T set(T element, int index);
	public abstract boolean remove(int index);
	public abstract int indexOf(T element);
	public abstract int size();
}
