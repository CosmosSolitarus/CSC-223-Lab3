import java.util.Comparator;
import java.util.List;

public class EquivalenceClasses<T> {

	protected Comparator<T> _comparator;
		
	protected List<LinkedEquivalenceClass<T>> _classes;
		
	
	public EquivalenceClasses(Comparator<T> comp) {
		_comparator = comp;
	}
	
	public boolean add(T element) {
		return false;
		// loop through each class in _classes
		// check if element belongs in class according to _comparator
		// if yes, add element
		// if no, check next class
	}

	/**
	 * Check if target occurs in any equivalence class
	 * 
	 * @param target
	 * @return
	 */
	public boolean contains(T target) {
		for (LinkedEquivalenceClass<T> lec : _classes) {
			if (lec.contains(target)) return true;
		}

		return false;
	}

	/**
	 * Counts all elements in all equivalence classes
	 * 
	 * @return
	 */
	public int size() {
		int count = 0;
		
		for (LinkedEquivalenceClass<T> lec : _classes) {
			count += lec.size();
		}
		
		return count;
	}

	/**
	 * Counts number of equivalence classes
	 * 
	 * @return
	 */
	public int numClasses() {
		return _classes.size();
	}

	/**
	 * Finds the index of the first equivalence class element
	 * occurs in. If element is not found, returns -1.
	 * 
	 * @param element
	 * @return
	 */
	protected int indexOfClass(T element) {
		for (int i = 0; i < _classes.size(); i++) {
			if (_classes.get(i).contains(element)) return i;
		}
		
		return -1;
	}

	public String toString() {
		return null;
	}
}
