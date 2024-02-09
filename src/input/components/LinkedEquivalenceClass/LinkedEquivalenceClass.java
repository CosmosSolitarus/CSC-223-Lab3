package input.components.LinkedEquivalenceClass;
import java.util.Comparator;

/**
 * Uses LinkedList data structure to determine elements fitting to a given equivalence class.
 * @date 2/9/2024
 * @author Sam Nusstein
 * @author Case Riddle
 * @author Jack Roberts
 **/

import input.components.LinkedList.LinkedList;

public class LinkedEquivalenceClass<T> {

	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;

	/**
	 * Creates new empty LinkedList and defines our comparator
	 * @param comp
	 */
	public LinkedEquivalenceClass(Comparator<T> comp) {
		_rest=new LinkedList<T>();
		_comparator=comp;
	}

	/**
	 * Returns the element defined as the canonical
	 * @return
	 */
	public T canonical() {
		return _canonical;
	}
	
	public boolean isEmpty() {
		return _rest.isEmpty();
	}

	public void clear() {
		_rest.clear();
	}

	/**
	 * Clears all elements apart from our canonical element
	 */
	public void clearNonCanonical() {
		_rest=new LinkedList<T>();
	}

	public int size() {
		return _rest.size();
	}

	/**
	 * adds a given element to the front of list
	 * @param element
	 * @return
	 */
	public boolean add(T element) {
		if(element==null) throw new NullPointerException();
		
		int ssize= size();
		_rest.addToFront(element);
		return(ssize!=size()); //If size has been increased, element has been added
	}
	
	public boolean contains(T target) {
		return _rest.contains(target);
	}

	/**
	 * Checks if a given element is of the same equivalence class of our canonical
	 * @param target
	 * @return
	 */
	public boolean belongs(T target) {
		return _comparator.compare(_canonical, target)==0;
	}

	public boolean remove(T target) {
		return _rest.remove(target);
	}

	/**
	 * Sets our canonical to null
	 * @return
	 */
	public boolean removeCanonical() {
		//returns true or false given the canonical was changed
		if(_canonical==null) return false;
		_canonical= null;
		return true;
	}

	//Replaces or sets a canonical element
	public boolean demoteAndSetCanonical(T element) {

		//Can we set canonical directly to null?
		if(contains(element)== false) throw new NullPointerException();

		//adds sets new cononical and removes it from list
		if(_canonical==null) {
			_canonical=element;
			_rest.remove(element);
			return true;
		}
		//adds canonical to list and sets new canonical
		_rest.addToFront(_canonical);
		_canonical=element;
		_rest.remove(element);
		return _rest.contains(element)==false;
	}

	/**
	 * Returns current list and canonical value as string
	 */
	public String toString() {
		if(isEmpty()) return "Empty Input";
		return _canonical+": "+_rest.toString();
	}
}
