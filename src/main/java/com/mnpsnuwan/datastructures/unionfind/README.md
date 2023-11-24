# Union Find
**Union Find** is a data structure that keeps track of elements which are split into one or more disjoint sets. Its has two primary operations; **_find_** and **_union_**

<img src="../../../../../resources/images/union-find.png" alt="union-find"/>

**When and where is a Union Find used?**
1. Kruskal's minimum spanning tree algorithm
2. Grid percolation
3. Network connectivity
4. Least common ancestor in trees
5. Image processing

### Complexity

| Operation          | UnionFind |
|--------------------|-----------|
| Construction       | O(n)      |
| Union              | α(n)      |
| Find               | α(n)      |
| Get component size | α(n)      | 
| Check if connected | α(n)      |
| Count components   | O(1)      |
* α(n) - Amortized constant time

#### Kruskal's Minimum Spanning Tree
- Given a graph G = (V, E) we want to find **Minimum Spanning Tree** in the graph (it may not be unique). A minimum spanning tree is a subset of the edges which connect all vertices in the graph with the minimal total edge cost.

<img src="../../../../../resources/images/minimum-spanning-tree.png" alt="minimum-spanning-tree"/>

1. Sort edges by ascending edge weight.
2. Walk through the sorted edge belongs to, if the nodes are already unified we don't include this edge, otherwise we include it and unify the nodes.
3. The algorithm terminates when every edge has been processed or all the vertices have been unified.

#### Creating Union Find
To begin using Union Find, first construct a **bijection** (a mapping) between your objects abd the integers in the range [0, n).
- **Note**: This step is not necessary in general, but it will allow us to construct an array-based union find.