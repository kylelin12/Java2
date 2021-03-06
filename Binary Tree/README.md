# Binary Tree
__**Def.**__
In a binary tree, each node, except the root has one parent.
Each node contains references to its left and right children, a null value indicates that the corresponding child is not in the tree.
A node that doesn't have and children is called a leaf.
Each node is a root of a smaller binary tree.

---

__**Ex.**__
```
Root -> 1
	   / \
	  2   3
	 /   / \
	4   5   6
	   / \
	  7   8
```
**8 Nodes**
* 1 is the root node.

**How many leaves?**
* 4

**Which nodes are leaves?**
* 4, 6, 7, 8

**What is the parent node of 5?**
* 3

**What are the children of node 2?**
* 4

---

__**Def.**__
The __height__ of a tree is the length of the longest parth from root to leaf.
(The number of links from root to leaf)
**What is the height of the tree given above?**
* 3

**^\*\*Trees^ ^are^ ^almost^ ^always^ ^handled^ ^recursively^**

---

# Tree Traversals
__**Def.**__
A __traversal__ is when each node is visited.
There are 3 common types of tree traversals:
* inorder
* preorder
* postorder

__**Inorder Traversal**__
1. Go left if possible.
2. Process that node.
3. Go right if possible.

_Ex._ What is the inorder traversal of the example binary tree?
2, 4, 1, 7, 5, 8, 3, 6

__**Preorder Traversal**__
1. Process the node
2. Go left if possible
3. Go right if possible

_Ex._ What is the preorder traversal of the example binary tree?
1, 2, 4, 3, 5, 7, 8, 6

__**Postorder Traversal**__
1. Go left if possible
2. Go right if possible
3. Process the node

__Ex.__ What is the postorder traversal of the examle binary tree?
4, 2, 7, 8, 5, 6, 3, 1

---

# Practice
(A) Given the binary tree
```
		 1
	   /   \
	  8     7
	   \    /\
	    3  9  11
	     \
	      10
```

__**Perform the following transversals**__

* Preorder: 1, 8, 3, 10, 7, 9, 11
* Inorder: 8, 10, 3, 1, 9, 7, 11
* Postorder: 10, 3, 8, 9, 11, 7, 1

(B) Given the following transversals
* Inorder: 3, 10, 8, 4, 9, 7, 11
* Preorder: 4, 8, 3, 10, 7, 9, 11
* Postorder: 10, 3, 8, 9, 11, 7, 4

Determine the binary tree.
```
		 4
	   /   \
	  8     7
	 /     / \
	3     9  11
     \
     10
```

__**Perform the transversals 2**__
```
			1
		  /   \
		 2     3
		  \   / \
		   4 5   6
		    / \
		   7   8
```

* Inorder: 2, 4, 1, 7, 5, 8, 3, 6
* Preorder: 1, 2, 4, 3, 5, 7, 8, 6
* Postorder: 4, 2, 7, 8, 5, 6, 3, 1
