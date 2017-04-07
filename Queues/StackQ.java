public class StackQ<E> {
	private Queue<E> _head;
	
	public StackQ() {
		_head = new NodeQueue<E>();
	}
	
	public boolean empty() {
		return _head.empty();
	}
	
	public void push(E val) {
		_head.queue(val);
	}
	
	public NodeQueue<E> last(NodeQueue<E> q) {
		
	}
	
	public E peek() {
		NodeQueue<E> tempQ = _head;
		for (int i = 0; i < tempQ.size(); i++) {
			tempQ.enqueue(tempQ.dequeue());
		}
		return tempQ.front();
	}
	
	public E pop() {
	
	}
}
