public class Replace{
	
	// post: replaces all occurances of oldValue with newValue
	public static<E> void replace(Queue<E> q, E oldValue, E newValue) {
		for (int i = 0; i < q.size(); i++) {
			if (q.front().equals(oldValue)) {
				q.dequeue();
				q.enqueue(newValue);		
			} else {
				q.enqueue(q.dequeue());
			}
		}
	}
}
