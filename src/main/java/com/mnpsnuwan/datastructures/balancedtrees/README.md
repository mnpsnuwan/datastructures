# Balanced Binary Search Trees (BBST)
A **Balanced Binary Search Trees (BBST)** is a **self-balancing** binary tree. This type of tree will adjust itself in order to maintain a low (logarithmic) height allowing for faster operations such as insertion and deletions.

### Complexity of Binary Search Trees
| Operation | Average   | Worst |
|-----------|-----------|-------|
| Insert    | O(log(n)) | O(n)  |
| Delete    | O(log(n)) | O(n)  |
| Remove    | O(log(n)) | O(n)  |
| Search    | O(log(n)) | O(n)  |

### Complexity of Balanced Binary Search Trees
| Operation | Average   | Worst     |
|-----------|-----------|-----------|
| Insert    | O(log(n)) | O(log(n)) |
| Delete    | O(log(n)) | O(log(n)) |
| Remove    | O(log(n)) | O(log(n)) |
| Search    | O(log(n)) | O(log(n)) |

#### Tree rotations
- The secret ingredient to most BBST algorithms is the clever usage of a **tree invariant** and **tree rotations**.
- A tree invariant is a property/rule you impose on your tree that it must meet after every operation. To ensure that the invariant is always satisfied a series of tree rotations are normally applied.

### AVL Tree
- An **AVL tree** is one of many types of **Balanced Binary Search Trees (BBST)** which allow for logarithmic **O(log(n))** iteration, deletion and search operations.
- In fact, it was the first type of BBST to be discovered. Soon after, many other types of BBSTs started to emerge including the 2-3 tree, the AA tree, the scapegoat tree, and it's main rival, the red black tree.

#### AVL Tree Invariant
- The property which keeps an AVL tree balanced is called the **Balanced Factor (BF)**.
```
BF(node) = H(node.right) - H(node.left) 

Where H(x) is the height of node x. Recall that H(x) is calculated as the 'number of edges' between x and the furthest leaf.
```
- The invariant in the AVL which forces it to remain balanced is the requirement that the balance factor is always either -1, 0, or +1.

#### Node Information to Store
- The actual value we're storing in the node. [**NOTE:** This value must be comparable so we know how to insert it.]
- A value storing this node's **balance factor**.
- The **height** of this node in the tree.
- Pointers to the **left/right child nodes**.

### Removing Elements from a BBST
- Remove elements from a BST can be seen as a two-step process.
  1. **Find** the element we wish to remove (if it exists)
  2. **Replace** the node we want to remove with its successor (if any) to maintain the BST invariant.
- Recall the **BST invariant**: left subtree has smaller elements and right subtree has larger elements.

#### Remove Phase
1. Node to remove is a leaf node.
   - If the node we wish to remove is a leaf node, then we may do so without side effect.
2. Node to remove has a right subtree but no left subtree.
   - The successor of the node we are trying to remove in this case will be the **immediate node down from the right subtree**.
   - It may be the case that we are removing the root node of the BST, in which case its immediate child becomes the new root, as you would expect.
3. Node to remove has a left subtree but no right subtree.
   - The successor of the node we are trying to remove in this case will be the **immediate node down from the left subtree**
   - It may be the case that we are removing the root node of the BST, in which case its immediate child becomes the new root, as you would expect.
4. Node to remove has both a left subtree and a right subtree.
   - The successor can either be the **largest value** in the **left subtree** or the **smallest value** in the **right subtree**.
- Once the successor node has been identified(if it exists), replace the value of the node to remove with the value in the successor node.
- **NOTE:** Don't forget to remove the duplicate value of the successor node that still exists in the tree at this point! One strategy to resolve this is by calling the function again recursively but with the value to remove as the value in the successor node.

#### Find Phase
- When searching the BST for a node with a particular value, one of four things will happen
  1. We hit a **null node** at which point we know the value does not exist within our BST.
  2. Comparator value **equal to 0** (found it!).
  3. Comparator value **less than 0** (the value, if exists, is in the left subtree!).
  4. Comparator value **greater than 0** (the value, if exists, is in the right subtree!).
