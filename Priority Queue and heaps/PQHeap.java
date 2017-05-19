import java.util.ArrayList;
import java.util.Comparator;

public class PQHeap < K,V > implements PriorityQueue < K,V > {

	private ArrayList < Entry < K,V >> _heap;
	private Comparator < K > _c;

	// private inner class

	private static class MyEntry < K,V > implements Entry < K,V > {
		private K _key;
		private V _value;

		public MyEntry(K key, V value) {
			_key = key;
			_value = value;
		}
		public K getKey() {
			return _key;
		}
		public V getValue() {
			return _value;
		}

		public String toString() {
			return "{" + _key + " : " + _value + "}";
		}
	}

	// ******** Question 1 ****************************
	// uses a default Comparator.
	public PQHeap() {
		_heap = new ArrayList < Entry < K,V >>();
		_c = new DefaultComparator < K > ();
	}

	// *******  Question 2 *****************************
	public PQHeap(Comparator < K > c) {
		_heap = new ArrayList < Entry < K,V >>();
		_c = c;
	}

	public boolean isEmpty() {
		return _heap.isEmpty();
	}

	// ******** Question 3 *****************************
	// pre: adds the key-value pair to the heap
	// post: 
	public void add(K key, V value) {
		if (_heap.size() == 0)
			_heap.add(new MyEntry < K,V > (key, value));
		else {
			int i = 0;
			while (_c.compare(_heap.get(i).getKey(), key) < 0)
				i++;
			_heap.add(i, new MyEntry < K,V > (key, value));
		}
	}

	// NEEDS TO BE COMPLETED
	// O(logN)
	public Entry < K,V > removeMin() {
		Entry < K,V > ans = _heap.get(0);
		Entry < K,V > x = _heap.remove(_heap.size() - 1);
		if (_heap.size() > 0) {
			_heap.set(0, x);
			int pos = 0;
			int mcPos = minChildPos(pos);
			while (mcPos != -1) {
				if (_c.compare(_heap.get(pos).getKey(),(_heap.get(mcPos).getKey())) < 0)
					break;
				_heap.set(pos, _heap.set(mcPos, _heap.get(pos)));
				pos = mcPos;
				mcPos = minChildPos(pos);
			}
		}
		return ans;
	}
	// NEEDS TO BE COMPLETED
	// return -1 if  pos has no children
	// otherwise returns the minimum child
	private int minChildPos(int pos) {
		int childL = pos * 2 + 1;
		int childR = childL + 1;
		if (childL >= _heap.size()) return -1;
		if (childR >= _heap.size() || _c.compare(_heap.get(childL).getKey(),(_heap.get(childR).getKey())) <= 0) return childL;
		return childR;
	}

	// O(1)
	public Entry < K,V > peekMin() {
		return _heap.get(0);
	}

	public String toString() {
		return _heap.toString();
	}

	public static void main(String[] args) {
		PriorityQueue < Integer,String > pq = new PQHeap < Integer,String > ();

		// the smallest key has a highest priority 
		pq.add(1, "apple");
		pq.add(5, "kiwi");
		pq.add(3, "cantalope");
		pq.add(1, "banana");
		pq.add(2, "orange");
		pq.add(2, "grapes");
		pq.add(1, "watermelon");

		System.out.println(pq);
		
		while (!pq.isEmpty()) {
			System.out.println(pq.removeMin());
		}
		// [{1 : apple}, {1 : banana}, {1 : watermelon},
		// {5 : kiwi}, {2 : orange}, {3 : cantalope}, {2 : grapes}]

	}

}
