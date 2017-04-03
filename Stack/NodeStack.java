public class NodeStack<E> implements Stack<E> {

	private Node<E> _head;
	
	public NodeStack() {
		_head = null;
	}
	
	// O(1)
	public boolean empty() {
		return _head == null;
	}
	
	// O(1)
	public void push(E value) {
		_head = new Node<E>(value, _head);
	}
	
	// O(1)
	public E peek() {
		if (empty())
			throw new EmptyStackException("Don't peek at an empty stack");
		return _head.getValue();
	}
	
	// O(1)
	public E pop() {
		if (empty())
			throw new EmptyStackException("Don't pop an empty stack");
		E temp = _head.getValue();
		_head = _head.getNext();
		return temp;
	}
	
	public static String reverse(String word) {
		Stack<String> s = new NodeStack<String>();
		for (int i = 0; i < word.length(); i++)
			s.push(word.substring(i, i+1));
		String ans = "";
		while (! s.empty())
			ans += s.pop();
		return ans;
	}
	
	public int search(E value) {
		Node<E> temp = _head;
		int ans = 1;
		while (temp.getNext() != null) {
			if (temp.getValue().equals(value)) return ans;
			temp = temp.getNext();
			ans++;
		}
		return -1;
	}
	
	public static void main(String [] args) {
		Stack<Integer> s = new NodeStack<Integer>();
		for (int i = 0; i < 10; i++)
			s.push(i);
		
		while (!s.empty())
			System.out.println(s.pop());
		
		s.peek();
	}
}
