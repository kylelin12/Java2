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
