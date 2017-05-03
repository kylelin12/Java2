public class BST < E extends Comparable > {

	/* Ordering property: Given a root, the items contained
       in the left subtree are less than the root, the items
       in the right subtree are greater or equal to the root.
    */

	private TreeNode < E > _root;
	private int _size;

	public BST() {
		_root = null;
		_size = 0;
	}
	public boolean isEmpty() {
		return _size == 0;
	}

	public int size() {
		return _size;
	}

	public void insert(E x) {
		insertNode(new TreeNode < E > (x));
	}

	// ******* Question 1 **********************
	// inserts the node into the BST.
	private void insertNode(TreeNode < E > n) {
		if (n == null) 
			_root = n;
		else if (n.getValue() < _root.getValue() && _root.getLeft() == null)
			_root.setLeft(n);
		else if (n.getValue() >= _root.getValue() && _root.getRight() == null)
			_root.setRight(n);
		else if (n.getValue() < _root.getValue())
			_root.getLeft()
	}

	public void inorder() {
		System.out.print("inorder: ");
		inorderTraversal(_root);
		System.out.println();
	}

	private void inorderTraversal(TreeNode < E > rt) {
		if (rt == null) return;
		inorderTraversal(rt.getLeft());
		System.out.print(rt.getValue() + " ");
		inorderTraversal(rt.getRight());
	}

	public static void main(String[] args) {
		BST < Integer > tree = new BST < Integer > ();
		int N = Integer.parseInt(args[0]);
		for (int i = 0; i < N; i++) {
			int r = (int)(Math.random() * 100);
			System.out.println("insert " + r);
			tree.insert(r);
		}
		tree.inorder();
	}

}
