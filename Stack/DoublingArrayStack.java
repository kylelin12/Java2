public class DoublingArrayStack<E> implements Stack<E> {

    private E[] _stack;
    private static final int INITIAL_CAPACITY = 1;
    private int _height;

    public DoublingArrayStack() {
		// causes a compiler warning: this is ok 
		_stack = (E[]) new Object[INITIAL_CAPACITY]; 
		_height = 0;

    }

    // accessor methods
    public int size() {
		return _height;
    }

    public boolean empty() {
		return size() == 0;
  	}
  	
    // ************** Question 1 **********************
    // returns true if the stack is full
    private boolean isFull() {
    	if (!(size() <= _stack.length))
			return false;
		return true;
    }

    
    // mutator methods
    // ************ Question 3 *************************
    // pushes val onto the top of the stack
    // if the stack if full the stack's size is doubled.
    public void push(E val) {
		if (isFull())
			doubleSize();
		_stack[_height++] = val;
    }

    // ************** Question 2 *****************************
    // Doubles the capacity of the stack.
    public void doubleSize() {
    	E[] temp = (E[]) new Object[_stack.length * 2];
    	transfer(_stack, temp);
    	_stack = temp;
    }

    // ************* Question 5 ******************************
    // reduces the capacity of the stack in half
    public void halfSize() {
		E[] temp = (E[]) new Object[_stack.length / 2];
    	transfer(_stack, temp);
    	_stack = temp;
    }

	public void transfer(E[] lhs, E[] rhs) {
		for (int i = 0; i < Math.min(rhs.length, lhs.length); i++)
			rhs[i] = lhs[i];
	}
    
    public E peek() {
		if (empty())
		    throw new EmptyStackException("empty stack");
		return _stack[_height - 1];
    }

    // ************* Question 4 ******************************
    // pops the top off the stack.
    // if the stack is less than 40% full, then cut the size of
    // the stack in half.
    public E pop() {
		E toReturn = _stack[_height--];
		if (1.0 * size() / _stack.length < 0.4)
			halfSize();
		return toReturn;
    }
    
    public String toString() {
        String ans ="[";
        if (size() > 0) ans += _stack[0];
        if (size() > 1) 
            for (int i = 1; i < size(); i++)
                ans += ", " + _stack[i];
        ans += "]";
		ans += "size: " + size() + " capacity: " + _stack.length;
		ans += " % full: " + 100.0 * size()/ _stack.length;
        return ans;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new DoublingArrayStack<Integer>();
		System.out.println(s);
        for (int i = 0; i < 16; i++) {
            s.push(i);
            System.out.println("push: " + i + " " + s);
        }
        System.out.println("peek: " + s.peek());
		System.out.println("**************START POPPING**************");
        while (!s.empty()){
            System.out.println("pop: " + s.pop() + " " + s);
        }
    }
}
