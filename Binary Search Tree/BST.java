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
	// Uses piggybacking
	private void insertNode(TreeNode < E > leaf) {
		E val = leaf.getValue();
		if (_root == null) _root = leaf;
		else {
			TreeNode < E > prev = _root;
			TreeNode < E > curr = _root;
			while (curr != null) {
				prev = curr;
				if (val.compareTo(curr.getValue()) < 0)
					curr = curr.getLeft();
				else
					curr = curr.getRight();
			}
			if (val.compareTo(prev.getValue()) < 0)
				prev.setLeft(leaf);
			else
				prev.setRight(leaf);
		}
		_size++;
	}
	
	// Question 2
	// Recursive version of insertion
	public void insertR(E val) {
		_root = insertNode(_root, new TreeNode < E >(val));
		_size++;
	}

	public TreeNode < E > insertNode(TreeNode < E > rt, TreeNode < E > leaf) {
		if (rt == null) return leaf;
		E val = leaf.getValue();
		if (val.compareTo(rt.getValue()) < 0)
			rt.setLeft(insertNode(rt.getLeft(), leaf));
		else
			rt.setRight(insertNode(rt.getRight(), leaf));
		return rt;
	}
	
	// Question 3
	// O(LogN) find()
	// Finds a value and reports that node
	public TreeNode < E > find(E val) {
		TreeNode < E > curr = _root;
		while (curr != null) {
			if (val == curr.getValue())
				return curr;
			else if (val.compareTo(curr.getValue()) < 0)
				curr = curr.getLeft();
			else
				curr = curr.getRight();
		}
		return null;
	}

	public TreeNode < E > findR(E val) {
		return find(_root, val);
	}

	private TreeNode < E > find(TreeNode < E > rt, E val) {
		if (rt == null) return null;
		if (val.compareTo(rt.getValue()) < 0)
			return find(rt.getLeft(), val);
		else if (val.compareTo(rt.getValue()) > 0)
			return find(rt.getRight(), val);
		return rt;
	}
	
	// Problem 4
	// Write the BST method that returns the max value
	private TreeNode < E > maxNode(TreeNode < E > rt) {
		if (rt == null) return null;
		while (rt.getRight() != null)
			rt = rt.getRight();
		return rt;
	}
	
	private TreeNode < E > maxNodeR(TreeNode < E > rt) {
		if (rt == null) return null;
		if (rt.getRight() == null)
			return rt;
		return maxNodeR(rt.getRight());
	}
	
	// Problem 5
	// Write the BST method that removes the node with that value

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
			int r = (int)(Math.random() * 5);
			System.out.println("insert " + r);
			tree.insertR(r);
		}
		tree.inorder();
		
		System.out.println("Finding Iterative (4): " + tree.find(4));
		System.out.println("Finding Recursive (3): " + tree.findR(3));
		
		System.out.println("MaxNode Iterative: " + tree.maxNode(tree._root));
		System.out.println("MaxNode Recursive: " + tree.maxNodeR(tree._root));
	}

}
