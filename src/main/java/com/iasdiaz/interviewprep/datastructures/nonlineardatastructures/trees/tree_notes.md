# Trees

Tree data structures are built using tree nodes and are another way of storing information. Specifically, trees are used
for data that has a hierarchical structure, such as a family tree or a computer’s file system. The tree data structure
you are going to create is an excellent foundation for further variations on trees, including AVL trees, red-black
trees, and binary search trees!

Trees come in various shapes and sizes depending on the dataset modeled.

Some are wide, with parent nodes referencing many child nodes.

Some are deep, with many parent-child relationships.

Trees can be both wide and deep, but each node will only ever have at most one parent; otherwise, they wouldn’t be
trees!

Each time we move from a parent to a child, we’re moving down a level. Depending on the orientation we refer to this as
the depth (counting levels down from the root node) or height (counting levels up from a leaf node).

To recap some terms:
 * root: A node which has no parent. One per tree.
 * parent: A node which references other nodes.
 * child: Nodes referenced by other nodes.
 * sibling: Nodes which have the same parent.
 * leaf: Nodes which have no children.
 * level: The height or depth of the tree. Root nodes are at level 1, their children are at level 2, and so on.


## Binary Search Trees

Binary search trees are a type of tree data structure with the added condition that each element to the left of a node
must be less than that parent node, and each element to the right of a node must be greater than that parent node. Each
left and right subtree is also itself a binary search tree, which makes searching for elements more efficient.

## Heaps

Heaps are another variation of the tree data structure and are adept at keeping track of the maximum or minimum value
held within, referred to as max-heaps and min-heaps, respectively. Specifically, heaps are a type of binary tree, since
each child node is either greater or less than its parent (depending on if it’s a max-heap or min-heap). They are
efficient for accessing the root value, which will either be the max or min (again, depending on the type of heap) and
inserting new values.