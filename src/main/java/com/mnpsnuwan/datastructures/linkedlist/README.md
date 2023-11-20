# Linked List
A linked list is a sequential list of nodes that hold data which point to other nodes also containing data.

```
(Data)->(Data)->(Data)->(Data)->(null)
```

**Where are linked lists used?**
1. Used in many List, Queue & Stack implementation.
2. Great for creating circular lists.
3. Can easily model real world objects such as trains.
4. Used in separate chaining, which is present certain Hashtable implementations to deal with hashing collisions.
5. Often used in the implementation of adjacency lists for graphs.

### Terminology
- **Head**: The first node in a linked list.
- **Tail**: The last node in a linked list.
- **Pointer**: Reference to another node.
- **Node**: An object containing data and pointer(s).

### Singly vs Doubly Linked Lists
**Singly Linked Lists** only hold a reference to the next node. In the implementation you always maintain a reference to the ***head*** to the linked list and a reference to the ***tail*** node for quick additions/removals.
```
(5)->(3)->(23)->(12)->(56)->(71)
```

With a **Doubly Linked List** each node holds a reference to the next and previous node. In the implementation you always maintain a reference to the ***head*** and the ***tail*** of the doubly linked list to do quick additions/removals from both ends of your list.
```
(5)<->(3)<->(23)<->(12)<->(56)<->(71)
```

#### Singly and doubly linked lists pros and cons

| List   | Pros                                              | Cons                                   |
|--------|---------------------------------------------------|----------------------------------------|
| Singly | - Uses less memory <br/> - Simpler implementation | Cannot easily access previous elements |
| Doubly | Can be traversed backwards                        | Takes 2x memory                        |

### Complexity

| Operation        | Singly | Doubly |
|------------------|--------|--------|
| Search           | O(n)   | O(n)   |
| Insert at head   | O(1)   | O(1)   |
| Inset at tail    | O(1)   | O(1)   |
| Remove at head   | O(1)   | O(1)   |
| Remove at tail   | O(n)   | O(1)   |
| Remove in middle | O(n)   | O(n)   |


