# Binary Search Tree

#### Def.
A **balanced** tree is a tree with the minimum possible maximum height.
* To calculate the minumum maximum height where N is the number of nodes in the tree:
* ⌊log₂N⌋ = minimum maximum height

#### Def.
A **binary search tree** (bst) is a binary tree with an ordering property.
We will use this ordering property:
> Given a root, the items contained in the left subtree are less than the root.
> The items in the right subtree are greater than or equal to the root.

The benefit of a BST is that if the tree is balanced then the following operations should be O(log₂N) where N is the number of items in the tree.
* find(x)
* insert(x)
* remove(x)

# The insert algorithm for a BST.
Given a value, x, start at the root and insert x as a leaf following these steps:
1. If the tree is empty then x is the root.
2. Else, if x is less than the current root and the left subtree is empty, insert x as the root of the left subtree.
3. Else, if x is greater than or equal to the root and the right subtree is empty, insert x as the root of the right subtree.
4. Else, if x is less than the current root, go left.
5. Else, go right.

# Practice
#### P1
Draw the following BST by inserting this sequence of numbers
`4, 8, 12, 5, 14, 21, 2, 1`

```
			 4
		    / \
		   2   8
		  /   / \
	   	 1   5   12
	   	     	  \
	   	     	   14
	   	     	  	\
	   	     	  	 21
```

#### P2
Perform an inorder traversal:
`1, 2, 4, 5, 8, 12, 14, 21`

#### P3
Is the tree balanced?
`No`

#### P4
Rearrange the sequence to produce a balanced tree.
`8, 4, 14, 2, 5, 12, 21, 1`
```
			 8
		   /   \
		  4     14
		 / \    / \
		2   5  12  21
	   /
	  1
```

#### P5
Draw the BST from
`12, 10, 8, 11, 25, 17, 6, 25`
```
			     12
			   /    \
			  10     25
			 /  \   /  \
			8   11 17  25
		   /
		  6
```

#### P6
Is this tree balanced?
`Yes`

#### P7
What is the expected runtime of building a balanced BST with N nodes?
`O(NLogN)`

#### P8
Draw a BST of N nodes whose runtime for building the tree is `O(N*N)`
```
25
  \
   26
    \
     27
      \
       28
        \
         29
```

#### Def.
A **internal node** of a binary tree is a node with at least 1 child.

#### Removal algorithm for a BST
Removing val from a BST
1. If the tree is empty then stop (DONE).
2. If the val is a leaf remove the leaf.
3. If the val is an internal node with no right subtree, then transfer the maximum value, max, from the left subtree into the node that voltains val, then remove max from the left subtree.
4. Otherwise, transfer the minimum value, min, from the right subtree into the node that contains val, then remove min from the right subtree.
