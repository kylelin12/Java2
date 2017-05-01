import java.util.List;
import java.util.ArrayList;
import java.util.Stack; // its a class 

public class TreeApp {

	public static < E > void traverseInorder(TreeNode < E > root) {
		if (root == null) return;
		traverseInorder(root.getLeft());
		System.out.print(root.getValue() + " ");
		traverseInorder(root.getRight());

	}
	public static < E > void traversePreorder(TreeNode < E > root) {
		if (root == null) return;
		System.out.print(root.getValue() + " ");
		traversePreorder(root.getLeft());
		traversePreorder(root.getRight());
	}
	public static < E > void traversePostorder(TreeNode < E > root) {
		if (root == null) return;
		traversePostorder(root.getLeft());
		traversePostorder(root.getRight());
		System.out.print(root.getValue() + " ");
	}
	// ********** Question 2 *********************************
	// Recursively process the tree to count the nodes.
	// postcondition: returns the number of nodes in the tree.
	public static < E > int countNodes(TreeNode < E > rt) {
		return - 1;
	}

	// ********** Question 3 *********************************
	// Iteratively process the tree to count the nodes.
	// Hint Use a Stack. In Java a Stack is a class with
	// the following methods:
	//   boolean empty()
	//   void push(E)
	//   E pop()
	//   E peek()
	public static < E > int countNodesI(TreeNode < E > rt) {
		return - 1;
	}

	public static void main(String[] args) {
		TreeNode < Integer > root = new TreeNode < Integer > (1, null, null);

		System.out.print("inorder : ");
		traverseInorder(root);
		System.out.print("\npreorder : ");
		traversePreorder(root);
		System.out.print("\npostorder : ");
		traversePostorder(root);
		System.out.println();

		System.out.println("# nodes: " + countNodes(root));
		System.out.println("# nodes: " + countNodesI(root));

	}

}
