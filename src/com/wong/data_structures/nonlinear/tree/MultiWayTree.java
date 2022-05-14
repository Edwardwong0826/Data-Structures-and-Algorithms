package com.wong.data_structures.nonlinear.tree;

public class MultiWayTree {

    // Multi-way tree is similar to BST but the tree can have more than two children
    // If a multiway tree have maximum m children, then this tree is called as multiway tree of order m (or an m-way tree).
    // example got B-Tree, B+Tree, B*Tree

    // 2-3 Tree features
    // 2-3 and 2-4 tree is B-Tree
    // -Nodes with two children are called 2-nodes. The 2-nodes have one data value and two children
    // -Nodes with three children are called 3-nodes. The 3-nodes have two data values and three children.
    // -It is a balanced tree.
    // -All the leaf nodes are at same level.
    // -Each node can either be leaf, 2 node, or 3 node.
    // -Data is stored in sorted order, always insertion is done at leaf.

    // B-Tree
    // some database index is B-Tree
    // All leaves are at the same level.
    // A B-Tree is defined by the term minimum degree ‘t’. The value of t depends upon disk block size.
    // Every node except root must contain at least t-1 keys. The root may contain minimum 1 key.
    // All nodes (including root) may contain at most 2*t – 1 keys.
    // Number of children of a node is equal to the number of keys in it plus 1.
    // All keys of a node are sorted in increasing order. The child between two keys k1 and k2 contains all keys in the range from k1 and k2.
    // B-Tree grows and shrinks from the root which is unlike Binary Search Tree. Binary Search Trees grow downward and also shrink from downward.
    // Like other balanced Binary Search Trees, time complexity to search, insert and delete is O(log n).
    // Insertion of a Node in B-Tree happens only at Leaf Node.
    // the data and index might put in non leaf node or leaf node

    // B+Tree
    // mostly like above
    // data only store in leaf node, and data in node linked list is order - which is dense index
    // non leaf node is leaf node index - which is sparse index
    // more suitable for file index system
}
