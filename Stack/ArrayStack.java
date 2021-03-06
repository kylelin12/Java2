public class ArrayStack<E> implements Stack<E> {

	// Private instance variables
	private E[] array;
	private int _arrayIndex;
	private int _capacity;
	
	// Constructors
	public ArrayStack(int capacity) { // O(1)
		array = (E[])new Object[capacity];
		_arrayIndex = -1;
		_capacity = capacity;
	}
		
	public ArrayStack() { // O(1)
		this(100);
	}
	
	// Methods
	public boolean empty() { // O(1)
		return _arrayIndex == -1;
	}
	
	public int size() { // O(1)
		return _capacity + 1;
	}
	
	public void push(E item) { // O(1)
		if (! _arrayIndex < _capacity)
			throw new FullStackException("FULL STACK");
		array[_arrayIndex++] = item;
	}
	
	public E peek() { // O(1)
		if (empty())
			throw new EmptyStackException("Don't peek at an empty stack");
		return array[_arrayIndex];
	}
	
	public E pop() { // O(1)
		if (empty())
			throw new EmptyStackException("Don't pop an empty stack");
		E toReturn = array[_arrayIndex--];
		return toReturn;
	}
	
	public void transferTo(ArrayStack<E> rhs) {
		if (this.empty())
			throw new EmptyStackException("Don't transfer an empty stack");
		while (!this.empty()) {
			if (rhs.size() != rhs._capacity)
				rhs.push(this.pop());
			else
				break;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stan = new ArrayStack<Integer>(3);
	}
}
