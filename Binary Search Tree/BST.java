import java.util.Iterator;
import java.util.ArrayList;

public class BST < E extends Comparable < E >> implements Iterable < E > {

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

	// Iterative version
	// returns null if val not found
	public TreeNode < E > find(E val) {
		TreeNode < E > curr = _root;
		while (curr != null && !val.equals(curr.getValue())) {
			if (val.compareTo(curr.getValue()) < 0) curr = curr.getLeft();
			else curr = curr.getRight();
		}
		return curr;
	}
	//********************************************************
	// Recursive version
	// post: return null if x not found
	public TreeNode < E > findR(E x) {
		return findR(_root, x);
	}

	private TreeNode < E > findR(TreeNode < E > rt, E x) {
		if (rt == null || x.equals(rt.getValue())) return rt;
		if (x.compareTo(rt.getValue()) < 0) return findR(rt.getLeft(), x);
		return findR(rt.getRight(), x);
	}
	//********************************************************
	public boolean isFound(E x) {
		return find(x) != null;
	}

	//********************************************************
	// pre: !isEmpty()
	public E maxValue() throws IllegalStateException {
		return maxValue(_root);
	}

	private E maxValue(TreeNode < E > rt) throws IllegalStateException {
		if (rt == null) throw new IllegalStateException("empty");
		return maxNode(rt).getValue();
	}
	//********************************************************
	private TreeNode < E > maxNode(TreeNode < E > rt) {
		if (rt != null) while (rt.getRight() != null) rt = rt.getRight();
		return rt;
	}
	//********************************************************
	// pre: !isEmpty()
	public E minValue() throws IllegalStateException {
		return minValue(_root);
	}

	private E minValue(TreeNode < E > rt) throws IllegalStateException {
		if (rt == null) throw new IllegalStateException("empty");
		return minNode(rt).getValue();
	}
	//********************************************************
	private TreeNode < E > minNode(TreeNode < E > rt) {
		if (rt != null) while (rt.getLeft() != null) rt = rt.getLeft();
		return rt;
	}
	//********************************************************
	/* Remove Algorithm for a BST
       ==========================
       Removing val from a BST.
       Steps
       1. if the tree is empty then stop.
       2. if the val is a leaf remove the leaf.
       3. if the val is an internal node with no right subtree,
          then transfer the maximum value,max, from the left subtree
          into the node that contains val, then remove max from the
          left subtree.  
       4. otherwise transfer the minimum value, min, from the right subtree
          into the node that contains val, then remove min from the right
           subtree.
    */

	public boolean remove(E val) {
		if (isFound(val)) {
			_root = remove(_root, val);
			_size--;
			return true;
		}
		return false;
	}
	// val is in the tree
	private TreeNode < E > remove(TreeNode < E > rt, E val) {
		if (isLeaf(rt)) return null;
		if (val.equals(rt.getValue())) {
			if (rt.getRight() == null) {
				E max = maxValue(rt.getLeft());
				rt.setValue(max);
				rt.setLeft(remove(rt.getLeft(), max));
			} else {
				E min = minValue(rt.getRight());
				rt.setValue(min);
				rt.setRight(remove(rt.getRight(), min));
			}
		} else {
			if (val.compareTo(rt.getValue()) < 0) rt.setLeft(remove(rt.getLeft(), val));
			else rt.setRight(remove(rt.getRight(), val));
		}
		return rt;
	}
	private boolean isLeaf(TreeNode < E > rt) {
		return (rt.getLeft() == null && rt.getRight() == null);
	}
	//********************************************************
	// Recursive version
	// inserts x as a  leaf
	public void insert(E x) {
		_root = insertNode(_root, new TreeNode < E > (x));
		_size++;
	}

	private TreeNode < E > insertNode(TreeNode < E > rt, TreeNode < E > leaf) {
		if (rt == null) return leaf;
		E val = leaf.getValue();
		if (val.compareTo(rt.getValue()) < 0) rt.setLeft(insertNode(rt.getLeft(), leaf));
		else rt.setRight(insertNode(rt.getRight(), leaf));
		return rt;
	}

	//********************************************************
	// Iterative version
	// inserts a leaf
	private void insertNode(TreeNode < E > leaf) {
		E val = leaf.getValue();
		if (_root == null) _root = leaf;
		else {
			TreeNode < E > curr = _root;
			TreeNode < E > prev = curr;
			while (curr != null) {
				prev = curr;
				if (val.compareTo(curr.getValue()) >= 0) curr = curr.getRight();
				else curr = curr.getLeft();
			}
			if (val.compareTo(prev.getValue()) >= 0) prev.setRight(leaf);
			else prev.setLeft(leaf);

		}
		_size++;
	}
	//********************************************************
	public String toString() {
		String ans = toString(_root);
		if (ans.length() > 1) {
			int pos = ans.lastIndexOf(",");
			ans = ans.substring(0, pos);
		}
		return ans;
	}
	// Uses an inorder traversal.
	private String toString(TreeNode < E > rt) {
		String ans = "";
		if (rt != null) {
			ans = toString(rt.getLeft()) + rt.getValue() + ", " + toString(rt.getRight());
		}
		return ans;
	}
	//********************************************************
	//********************************************************
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
	//********************************************************
	public void preorder() {
		System.out.print("preorder: ");
		preorderTraversal(_root);
		System.out.println();
	}

	private void preorderTraversal(TreeNode < E > rt) {
		if (rt == null) return;
		System.out.print(rt.getValue() + " ");
		preorderTraversal(rt.getLeft());
		preorderTraversal(rt.getRight());
	}
	//********************************************************
	public void postorder() {
		System.out.print("postorder: ");
		postorderTraversal(_root);
		System.out.println();
	}

	private void postorderTraversal(TreeNode < E > rt) {
		if (rt == null) return;
		postorderTraversal(rt.getLeft());
		postorderTraversal(rt.getRight());
		System.out.print(rt.getValue() + " ");
	}
	// ***************** Question 5 ****************************
	/*  Add an iterator for the BST.
        The iterator must process the data inorder.
        A call to hasNext() and next() must be O(1).
        A call to remove() must be O(log N).
     */
	// *********************************************************
	// *********************************************************
	// needed for the Iterable interface
	public Iterator < E > iterator() {
		return new BST_Iterator(_root);
	}

	private class BST_Iterator implements Iterator < E > {
		private BST < E > _tree;
		private ArrayList < E > _list;
		// a list of the BST entries
		// stored in increasing order 
		private Iterator < E > _itr;
		private E _valReturned;
		// last value returned by a call of next();
		// will be null if either next() was not called or when
		//              remove() is called 
		// O(N log N)
		// populates a list of the tree's entries in increasing order
		public BST_Iterator(BST < E > tree) {
			_tree = tree;
			populate(_list, _tree);
		}
		// O(N)
		// populates L with the vales from the BST represented by rt.
		// L is in increasing order.
		private void populate(ArrayList < E > L, TreeNode < E > rt) {
			while (!isLeaf(rt))
				L.add(rt.minValue());
		}

		// O(1)
		// checks if _list's iterator has a next value.
		public boolean hasNext() {
			return true;
		}

		// O(1)
		// Initializes _valReturned and returns the
		// value of _valReturned.
		public E next() throws IllegalStateException {
			return null;
		}

		// O(logN)
		// removes the value from the BST not the list
		// sets the _valReturned variable to null
		public void remove() throws IllegalStateException {
			return;
		}
	}
	// *********** End of Question 5 ************************
	// ******************************************************
	//********************************************************
	public static void main(String[] args) {
		BST < Integer > tree = new BST < Integer > ();
		int N = 10; //Integer.parseInt(args[0]);
		for (int i = 0; i < N; i++) {
			int r = (int)(Math.random() * 100);
			System.out.println("insert " + r);
			tree.insert(r);
			System.out.println("tree: " + tree);
		}

		tree.inorder();
		tree.preorder();
		tree.postorder();
		System.out.println("Max value: " + tree.maxValue());

		while (!tree.isEmpty()) {
			Integer max = tree.maxValue();
			System.out.println("max : " + max);
			tree.remove(max);
			System.out.println("remove max: " + tree);
		}

		/*
	for(Integer n : tree){
	    System.out.println(n);
	}

	Iterator<Integer> itr = tree.iterator();
	while (itr.hasNext()){
	    if (itr.next() % 2 == 0) itr.remove();
	    //itr.remove(); // should throw an exception
	}

	for(Integer n : tree){
	    System.out.println(n);
	}
	*/
	}

}
