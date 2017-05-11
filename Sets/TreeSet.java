import java.util.Iterator;

public class TreeSet < E extends Comparable < E > >implements Set < E > {
	private BST < E > _tree;

	public TreeSet() {
		_tree = new BST < E > ();
	}

	public boolean add(E val) {
		if (contains(val)) return false;
		_tree.insert(val);
		return true;
	}

	public boolean contains(E val) {
		return _tree.isFound(val);
	}

	public boolean remove(E val) {
		_tree.remove(val);
		return true;
	}

	public int size() {
		return _tree.size();
	}

	public Iterator < E > iterator() {
		return _tree.iterator();
	}

	public static void main(String[] args) {
		String str = args[0];
		Set < String > s = new TreeSet < String > ();
		for (int i = 0; i < str.length(); i++) {
			s.add(str.substring(i, i + 1));
		}
		for (String a: s) {
			System.out.println(a);
		}
	}
}
