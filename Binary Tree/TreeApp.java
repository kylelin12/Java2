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
	public static < E > int countNodes(TreeNode < E > root) {
		if (root == null) return 0;
		int ans = 1;
		return ans + countNodes(root.getLeft()) + countNodes(root.getRight());
	}

	// ********** Question 3 *********************************
	// Iteratively process the tree to count the nodes.
	// Hint Use a Stack. In Java a Stack is a class with
	// the following methods:
	//   boolean empty()
	//   void push(E)
	//   E pop()
	//   E peek()
	public static < E > int countNodesI(TreeNode < E > root) {
		if (root == null) return 0;
		int count = 0;
		TreeNode < E > temp = root;
		Stack < TreeNode > treeStack = new Stack < TreeNode > ();
		while (!treeStack.empty() || temp != null) {
			if (temp != null) {
				treeStack.push(temp);
				temp = temp.getLeft();
			} else {
				count++;
				temp = treeStack.pop();
				temp = temp.getRight();
			}
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode < Integer > root = new TreeNode < Integer > (1, new TreeNode < Integer > (2, null, new TreeNode < Integer > (4)), new TreeNode < Integer > (3, new TreeNode < Integer > (5, new TreeNode < Integer > (7), new TreeNode < Integer > (8)), new TreeNode < Integer > (6)));
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
