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

	public static int removeMin(ArrayList < Integer > heap) {
		int ans = heap.get(0);
		int x = heap.remove(heap.size() - 1);
		if (heap.size() > 0) {
			heap.set(0, x);
			int pos = 0;
			int mcPos = minChildPos(pos, heap);
			while (mcPos != -1) {
				if (heap.get(pos) < heap.get(mcPos))
					break;
				heap.set(pos, heap.set(mcPos, heap.get(pos)));
				pos = mcPos;
				mcPos = minChildPos(pos, heap);
			}
		}
		return ans;
	}
	
	
	// pre: heap != null
	// post: returns the position of the minimum child of value at pos or -1 if pos is a leaf
	public static int minChildPos(int pos, ArrayList < Integer > heap) {
		int childL = pos * 2 + 1;
		int childR = childL + 1;
		if (childL >= heap.size()) return -1;
		if (right >= heap.size() || heap.get(left) <= heap.get(right)) return left;
		return right;
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
