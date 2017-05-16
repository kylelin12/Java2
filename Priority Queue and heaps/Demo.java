import java.util.PriorityQueue;

public class Demo {

	// sorts the list in nondecreasing order by using a priority queue
	public static void pqSort(String[] list) {
		PriorityQueue < String > temp = new PriorityQueue < String > ();
		for (String item: list) {
			temp.add(item);
		}
		for (int i = 0; i < list.length; i++) {
			list[i] = temp.poll();
		}
	}
	
	public static void add(int v, ArrayList < Integer > heap) {
		heap.add(v);
		int pos = heap.size() - 1;
		int parent;
		while (pos > 0) {
			parent = (pos - 1) / 2;
			if (heap.get(parent) > heap.get(pos))
				heap.set(pos, heap.set(parent, heap.get(pos)));
			else
				break;
		}
	}

	public static void main(String[] args) {
		String[] fruits = {
			"kiwi",
			"pear",
			"apple",
			"banana",
			"watermelon",
			"grapes",
			"cantalope",
			"orange"
		};
		PriorityQueue < String > pq = new PriorityQueue < String > ();

		for (String fruit: fruits) {
			pq.add(fruit);
			System.out.println("pq: " + pq);
		}

		while (pq.size() != 0) {
			System.out.println("peek: " + pq.peek());
			System.out.println("remove: " + pq.poll());

		}
	}
}
