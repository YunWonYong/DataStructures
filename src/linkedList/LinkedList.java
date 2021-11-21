package linkedList;

public interface LinkedList<T> {
	public abstract int add(T value); //insert
	public abstract int set(int index, T value);
	public abstract int remove(int value);
	public abstract boolean remove(Object el);
	public abstract int indexOf(T value);
	public abstract T get(int index);
	public abstract int size();
	public abstract void clear(); // destroy
}
