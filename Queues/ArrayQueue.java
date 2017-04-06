public class ArrayQueue<E> implements Queue<E> {
	private E[] _queue;
	private static final int CAPACITY = 100;
	private int _head, _tail, _size;
	
	public ArrayQueue(int size) {
		_queue = (E[])(new Object[size]);
		_head = 0;
		_tail = -1;
		_size = 0;
	}
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public int size() {
		return _size;
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public E front() throws EmptyQueueException {
		if (empty()) throw new EmptyQueueException("Can't look at an empty queue");
		return _queue[_head];
	}
	
	public E dequeue() throws EmptyQueueException {
		if (empty()) throw new EmptyQueueException("Can't dequeue an empty queue");
		E toReturn = _queue[_head];
		_queue[_head] = null;
		_head = (_head + 1) % _queue.length;
		_size--;
		return toReturn;
	}
	
	public void enqueue(E val) {
		if (isFull()) return;
		_tail = (_tail + 1) % _queue.length;
		_queue[_tail] = val;
		_size++;
	}
	
	public boolean isFull() {
		return size() == _queue.length;
	}
	
	public String toString() {
		if (empty()) return "[ ]";
		String string = "[ ";
		for (int i = 0; i < size() - 1; i++) {
			string += _queue[(_head + i) % _queue.length] + ", ";
		}
		string += _queue[_tail] + " ]";
		return string;		
	}
	
    public static void main(String [] args) {
        Queue q = new ArrayQueue(5);
        System.out.println(q);
	
        for (int i = 0; i < 5 ; i++){
            q.enqueue(i);
            System.out.println("enqueue : " + i + " q: " + q);
        }

        while (!q.empty()){
            if (Math.random() < 0.75)
                System.out.println("dequeue " + q.dequeue() + " q: " + q);
            else {
                int x = (int)(Math.random() * 100) ;
                q.enqueue(x);
                System.out.println("enqueue : " + x + " q: " + q);
            }
        }
        for (int i = 0; i < 5 ; i++){
            q.enqueue(i);
            System.out.println("enqueue : " + i + " q: " + q);
        }
        for (int i = 0; i < 4 ; i++){
            System.out.println("dequeue : " + q.dequeue() + " q: " + q);
        }
    }
}
