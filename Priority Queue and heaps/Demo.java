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
		if (heap.size() == 1) heap.remove(0);
		else {
			int pos = heap.indexOf(v);
			heap.set(heap.size() - 1, heap.set(pos, heap.get(heap.size() - 1);
			heap.remove(heap.size() - 1);
			int child = (pos * 2) + 1;
			while (heap.get(child) != null && heap.get(child + 1) != null) {
				int minChild = Math.min(heap.get(child), heap.get(child + 1));
				if (heap.get(pos) > heap.get(minChild)) {
					heap.set(pos, heap.set(minChild, heap.get(pos)));
				}	
			}
		}
	}

	public static void remove(int v, ArrayList < Integer > heap) {
		int pos = heap.indexOf(v);
		int child = (pos * 2) + 1;
		if (heap.get(child) == null && heap.get(child + 1) == null) return;
		else {
			heap.set(pos, heap.set(child, heap.get(pos)));
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
