package com.wong.data_structures.nonlinear.tree;

public class AvlTree extends BinarySearchTree{

    // AVL tree also called self-balancing tree, is a binary search tree that optimise that efficiency of traverse operations
    // by rotate the left tree or right tree, when either tree height is > 1, AVL must be empty tree or both tree height cannot > 1

    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AvlTree avlTree = new AvlTree();
        for(int i = 0; i < arr.length; i++)
        {
            avlTree.add(new Node(arr[i]));
        }

        avlTree.inOrder();
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());

    }
}
