# Binary Trees and Binary Search Tree (BST)

### Tree
A **tree** is an **undirected graph** which satisfies any of the following definitions:
- An acyclic connected graph.
- A connected graph with N nodes and N-1 edges.
- A graph in which any two vertices are connected by exactly one path.

### Leaf Node
A **leaf node** is a node with no children. These have been highlighted as blue.

<img src="../../../../../resources/images/leaf-node.png" alt="leaf-node"/>

### Sub Tree
A **subtree** is a tree entirely contained within another. They are usually denoted using triangles.
- **Note**: Subtrees may consist of a single node!.

<img src="../../../../../resources/images/subtree.gif" alt="subtree"/>

### Binary Tree
A **binary tree** is a tree for which every node has at most two child nodes.

<img src="../../../../../resources/images/binary-tree.png" alt="binary-tree"/>

### Binary Search Tree (BST)
A **binary search tree** is a binary tree that satisfies the **BST invariant**: left subtree has smaller element and right subtree has larger elements.

<img src="../../../../../resources/images/binary-search-tree.png" alt="binary-search-tree"/>

**When and where are Binary Trees used?**
1. Binary Search Trees (BSTs).
    - Implementation of some map and set ADTs.
    - Red Black Trees.
    - AVL Trees.
    - Splay Trees.
    - etc.
2. Used in the implementation of binary heaps.
3. Syntax trees (used by compiler and calculators).
4. Treap - a probabilistic data structure (uses a randomized BST).

### Complexity of BSTs

| Operation | Average   | Worst |
|-----------|-----------|-------|
| Insert    | O(log(n)) | O(n)  |
| Delete    | O(log(n)) | O(n)  |
| Remove    | O(log(n)) | O(n)  |
| Search    | O(log(n)) | O(n)  |


