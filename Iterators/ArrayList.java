public class ArrayList<E> implements List<E>{

	private E[] _data;
	private int _size;


	// constructor
	public ArrayList() {
		_data = (E[]) new Object[10]; // issues compiler warning - OK
		_size = 0;
	}


	public int size() {
		return _size;
	}
	// postcondition : doubles the capacity
	private void resize() {
		if (size() != _data.length) return;
		E[] temp = (E[]) new Object[size() * 2]; // issues compiler warning - OK
		for (int i = 0; i < size(); i++)
			temp[i] = _data[i];
		_data = temp;
	}

	// postondition: add obj to the end of the list.
	public boolean add(E obj) {
		if (size() == _data.length) resize();
		_data[_size++] = obj;
		return true;
	}

	// *********** Question 1  **********************
	/*
	Inserts obj at position index.
	Assume L = []
	method invocation          state of L after method invocation
	L.add(0,"a") ;              ["a"]
	L.add(1,"b") ;              ["a", "b" ]
	L.add(1, "c");              ["a, "c", "b"]


	*/
	// postcondition: 
	public void add(int index, E obj) throws IndexOutOfBoundsException {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException("index : " + index);
		if (size() == _data.length) resize();
		for (int i = size(); i > index; i--) {
			_data[i] = _data[i-1];
		}
		_data[index] = obj;
		_size++;
	}		


	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("index : " + index);
		return _data[index];
	}
	
	public E set(int index, E obj) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("index : " + index);
		E ans =  _data[index];
		_data[index] = obj;
		return ans;
	}

	// *********  Question: 2  ************************
	/*
	Assume L = ["a","b","c","d"]
	Method invocation   Value Returned  State of L after method invocation
	L.remove(0)             "a"          ["b","c","d"]
	L.remove(1)             "c"          ["b","d"]
	L.remove(0)             "b"          ["d"]
	L.remove(0)             "d"          []
	*/  
	// postcondition: removes and returns the obj at index E
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("index : " + index);
		E temp = _data[index];
		_size--;
		for (int i = index; i < _size; i++) {
			_data[i] = _data[i+1];
		}
		_data[_size] = null; // Frees Element
		return temp;
	}

	public String toString() {
		String ans = "[";
		for (int i = 0; i < size(); i++)
			ans += get(i) + ", ";
		if (ans.length() > 2)
			ans = ans.substring(0, ans.length() - 2);
		ans += "]";
		return ans + "size: " + size();
	}


	public static void main(String [] args) {
		ArrayList<Integer> L = new ArrayList<Integer>();
		System.out.println("L: " + L);

		for (int i = 0; i < 10; i++){
			L.add(i);
			System.out.println("L: " + L);
		}

		for (int i = 10; i < 20; i++){
			int r = (int)(Math.random() * L.size() + 1);
			System.out.println("r: " + r);
			L.add(r, i);
			System.out.println("L: " + L);
		}
		
		System.out.println("************ REMOVING **********");
		while (L.size() > 0){
			int r = (int)(Math.random() * L.size());
			System.out.println(" remove " + L.remove(r));
			System.out.println("L: " + L);
		}
	}
}
