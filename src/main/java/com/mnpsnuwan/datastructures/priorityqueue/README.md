# Priority Queue
A priority queue is an Abstract Data Type (ADT) that operates similar to a normal queue except that ***each element has a certain priority***. The priority of the elements in the priority queue determine the order in which elements are removed from the PQ.
- **NOTE** - Priority queues only supports **comparable data**, meaning the data inserted into the priority queue must be able to be ordered in some way either from least to greatest or greatest to least. This is so that we are able to assign relative priorities to each element.

## Heap
A heap is a **tree** based Data Structure that satisfies the **heap invariant** (also called heap priority); If 'A' is a parent node of 'B' then 'A' is ordered with respect to 'B' for all nodes 'A', 'B' in the heap.

<img src="../../../../../resources/images/heap.png" alt="heap"/>

**When and where is a Priority Queue used?**
1. Used in certain implementations of Dijkstra's Shortest Path algorithm.
2. Anytime you need the dynamically fetched the 'next best' or 'next worst' element.
3. Used in Huffman cording (which is often used for lossless data compression)
4. Best First Search (BFS) algorithms such as A* use PQs to continuously grab the next most promising node.
5. Used by Minimum Spanning Tree (MST) algorithms.

### Complexity Priority Queue with Binary Heap

| Operation                                     | Queue     |
|-----------------------------------------------|-----------|
| Binary Heap construction                      | O(n)      |
| Poll                                          | O(log(n)) |
| Peek                                          | O(1)      |
| Add                                           | O(log(n)) |
| Naive Remove                                  | O(n)      |
| Advanced removing with help from a hash table | O(log(n)) |
| Naive Contains                                | O(n)      |
| Contains check with help of a hash table      | O(1)      |

**Important**: Using a hash table to help optimize these operations does take up linear space and also adds some overhead to the binary heap implementation.

#### Turning Min PQ into Max PQ
Since elements in a PQ are comparable they implement some sort of **comparable interface** which we can simply **negate** to achieve a Max heap. 

#### Ways of Implementing a Priority Queue
- Priority Queues are usually implemented with heaps since this gives them the best possible time complexity.
- The Priority Queue is an **Abstract Data Type (ADT)**, hence heaps are not the only way to implement PQs. As an example, we could use an unsorted list, but this would not give us the best possible time complexity.

#### Priority Queue with Binary Heap
1. Binary Heap
2. Fibonacci Heap
3. Binomial Heap
4. Paring Heap

##### Binary Heap
A **binary heap** is a **binary tree** that supports the **heap invariant**. In a binary tree every node has exactly two children.
* Let _i_ be the parent node index, then; 
  * Left child index: 2i + 1 
  * Right child index: 2i + 2 (zero based)

##### Complete Binary Tree
A **complete binary tree** is a tree in which at every level, except possibly the last is completely filled and all the nodes are as far left as possible.



