# Hash Table
A **Hash Table (HT)** is a data structure that provides a mapping from keys to values using a technique called **hashing**.

- HTs are often used to track item frequencies. For instance, counting the number of times a word appears in a given text.

### Properties of Hash Function
If **H(x) = H(y)** then objects x and y **might be equal**, but if **H(x) != H(y)** then x and y are **certainly not equal**.

### How does a hash table work?
- **Separate chaining** deals with hash collisions by maintaining a data structure (usually a linked list) to hold all the different values which hashed to a particular value.
- **Open addressing** deals with hash collisions by finding another place within the hash table for the object to go by offsetting it from the position to which it hashed to.

### Complexity of BSTs

| Operation | Average | Worst |
|-----------|---------|-------|
| Insert    | O(1)*   | O(n)  |
| Delete    | O(1)*   | O(n)  |
| Search    | O(1)*   | O(n)  |
/*The constant time behaviour attributed to hash table is only true if you have a good **uniform hash function**./

### Hash Table Separate Chaining
**Separate Chaining** is one of many strategies to deal with hash collisions by maintaining a data structure (usually a linked list) to hold all the different values which hashed to a particular value.

- **NOTE:** The data structure used to cache the items which hashed to a particular value is not limited to a linked list. Some implementations use one or a mixture of: arrays, binary trees, self-balancing trees and etc...

