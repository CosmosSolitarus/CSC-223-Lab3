import LinkedList.Node;

/**
 * Methods that initialize and operate a linked list datatype.
 * @date 2/6/2024
 * @author Case Riddle
 * @author Sam Nusstein
 * @author Jack Roberts
 **/

public class LinkedList<T> {
	protected Node _head;
	protected Node _tail;
	protected int _size;

	protected class Node {
		protected T _data;
		protected Node _next;

		public Node() {
			this(null, null);
		}

		public Node(T data, Node next) {
			_data = data;
			_next = next;
		}
	}

	/**
	 * Creates sentinel nodes and an empty linked list.
	 **/
	public LinkedList() {
		_tail = new Node(null, null);
		_head = new Node(null, _tail);
		_size = 0;
	}

	public boolean isEmpty() {
		return _size == 0;
	}

	public void clear() {
		_head = null;
		_tail = null;
		_size = 0;
	}

	public int size() {
		return _size;
	}

	/**
	 * Creates a new node and increments the size.
	 * @param element
	 **/
	public void addToFront(T element) {
		Node n = new Node(element, _head._next);
		_head._next = n;
		_size++;
	}

	/**
	 * Iterates until the target is reached.
	 * Returns n.
	 * @param target
	 **/
	public boolean contains(T target) {
		Node n = _head._next;
		while (n != _tail) {
			if (n._data.equals(target)) {
				return true;
			}
			n = n._next;
		}
		return false;
	}

	/**
	 * Iterates until the target is the next element, not until it is reached.
	 * Returns n.
	 * @param target
	 **/
	private Node previous(T target) {
		Node n = _head;
		while (n._next != _tail) {
			if (n._next._data.equals(target)) {
				return n;
			}
			n = n._next;
		}
		return null;
	}

	public boolean remove(T target) {

	}


	private Node last() {
		return null;
	}

	/**
	 * Adds the specified element to the location after the tail.
	 * @param element
	 **/
	public void addToBack(T element) {
		Node n = new Node(element, _tail._next);
		n._next = _tail._next;
		_tail = n;
		_size++;
	}

	public void reverse() {

	}

	@Override
	public String toString() {
		StringBuilder s=new StringBuilder("");
		Node ptr=_head;
		while(ptr!=null) {
			s.append(ptr._data+";");
			ptr=ptr._next;
		}
		return s.toString();
	}
}