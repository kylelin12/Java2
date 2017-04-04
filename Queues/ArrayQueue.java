public class ArrayQueue<E> implements Queue<E> {
	private E[] _queue;
	private int _length;
	private int _currentSize;
	private int _currentPos;
	
	public ArrayQueue() {
		ArrayQueue(10);
	}
	
	public ArrayQueue(int size) {
		_queue = (E[]) new Object[size];
		_currentPos = _length = size;
		_currentSize = 0;	
	}
	
	public int size() {
		return _currentSize;
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public E front() throws EmptyQueueException {
		if (empty()) throw new EmptyQueueException("Can't look at an empty queue");
		return _queue[_currentPos];
	}
	
	public E dequeue() throws EmptyQueueException {
		if (empty()) throw new EmptyQueueException("Can't dequeue an empty queue");
		E toReturn = _queue[_currentPos--];
		_currentSize--;
		return toReturn;
	}
	
	public void enqueue(E val) {
		if (isFull()) return;
		if (_currentPos < _length) {
			_queue[_currentPos] = val;
			_currentPos++;
		} else
			_queue[_length - _currentSize] = val;
		_currentSize++;
	}
	
	public boolean isFull() {
		return (_currentPos == _length) || (_length == _currentSize);
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
    }
}
