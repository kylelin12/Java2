import java.util.ArrayList;

public class Demo_II {

	public static void add(int v, ArrayList < Integer > heap) {
		heap.add(v);
		int pos = heap.size() - 1;
		int parent;
		while (pos > 0) {
			parent = (pos - 1) / 2;
			if (heap.get(parent) > v) {
				heap.set(parent, heap.set(pos, heap.get(parent)));
				pos = parent;
			}
			else break;

		}
	}

	public static void removeMin(ArrayList < Integer > heap) {
		heap.set(0, heap.set(heap.size() - 1, heap.get(0)));
		heap.remove(heap.size() - 1);
		if (heap.getSize() > 0) removeHelper(0, heap);
	}
	
	public static void removeHelper(int index, ArrayList < Integer > heap) {
		int childL = (index * 2 + 1);
		int childR = (childL + 1);
		while ((heap.get(childL) != null && heap.get(childR) != null) || heap.get(index)
	}

	public static void main(String[] args) {
		ArrayList < Integer > heap = new ArrayList < Integer > ();
		int[] vals = {
			3,
			89,
			12,
			5,
			35,
			4,
			14,
			0
		};

		for (int x: vals) {
			add(x, heap);
			System.out.println("add " + x);
			System.out.println("heap " + heap);
		}

	}

}
