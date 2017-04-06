import java.util.ArrayList;
public class Josephus {
	public static<E> Queue<E> buildQueue(ArrayList<E> players) {
		Queue<E> _queue = new NodeQueue<E>();
		for (int i = 0; i < players.size(); i++) {
			_queue.enqueue(players.get(i));
		}
		return _queue;
	}
	
	// returns the winner
	public static<E> E josephus(Queue<E> q, int k) {
		while (q.size() > 1) {
			for (int i = 0; i < k; i++) {
				q.enqueue(q.dequeue);
			}
			q.dequeue();
		}
		return q.front();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> players = new ArrayList(16);
		for (int i = 0; i < players.size(); i++) {
			players.add(i);
		}
		Queue<Integer> queue = buildQueue(players);
		System.out.println(josephus(queue, 2));
	}
}
