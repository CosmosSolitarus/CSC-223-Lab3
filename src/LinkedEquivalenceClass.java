
import input.components.linkedlist.LinkedList.Node;

public class LinkedEquivalenceClass<T> {

	protected T _canonical;

	protected Comparator<T> _comparator;

	protected LinkedList<T> _rest;


	public LinkedEquivalenceClass(Comparator<T> comp) {
		_rest=new LinkedList<T>();
	}

	public T canonical() {
		return _canonical;

	}
	public boolean isempty() {
		return _rest.isEmpty();

	}

	public void clear() {
		_rest.clear();

	}
	public void clearNonCanonical() {

	}
	public int size() {
		return _rest.size();

	}
	public boolean add(T element) {
		if(_rest.contains(element)) {
			return false;
		}
		_rest.addToBack(element);
		if(_rest.contains(element))return true;
		return false;


	}
	public boolean contains(T target) {
		return _rest.contains(target);

	}
	public boolean belongs(T target) {
		return false;

	}
	public boolean remove(T target) {
		return _rest.remove(target);

	}
	public boolean removeCanonical() {
		return _rest.remove(_canonical);

	}
	public boolean demoteAndSetCanonical(T element) {
		return false;

	}
	public String toString() {
		StringBuilder s=new StringBuilder("LinkedList:");
		Node ptr=_head;
		while(ptr!=null) {
			s.append(ptr.data+";");
			ptr=ptr.next;
		}
		return s.toString();
		return null;

	}
}
