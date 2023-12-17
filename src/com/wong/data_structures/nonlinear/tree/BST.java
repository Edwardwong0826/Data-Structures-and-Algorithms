package com.wong.data_structures.nonlinear.tree;

import java.util.ArrayList;
import java.util.List;

class BST
{
    public static void inOrderTraverse(TreeNode root, List<Integer> pre){
        if(root == null)
            return;
        inOrderTraverse(root.left,pre);
        pre.add(root.val);
        inOrderTraverse(root.right,pre);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return root = new TreeNode(val);
        if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return root;
        if(root.val == val){
            return root;
        }
        else{
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) {
            return root;
        }

        //find the target
        if(root.val > val) {
            root.left = deleteNode(root.left, val);
            return root;
        } else if(root.val < val) {
            root.right = deleteNode(root.right, val);
            return root;
        }

        //No child or only one child
        if(root.left == null && root.right == null) {
            return null;
        } else if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        }

        //Two children
        if(root.right.left == null) { // this part delete the node if node is at left side
            root.right.left = root.left;
            return root.right;
        } else { // { // this part delete the node if node is at right side
            TreeNode smallest = deleteSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }


    }

    public TreeNode deleteSmallest(TreeNode root){
        TreeNode pre = root;
        TreeNode cur = root.left;
        while(cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        return cur;
    }

    // convert sort array to BST
    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low+high) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, low, mid-1);
        root.right = helper(num, mid+1, high);

        return root;


    }

    public static void main(String[] args)
    {
        //int[] arr = {4,2,7,1,3};
        int[] arr = {5,3,6,2,4,7};

        BST bst = new BST();
        TreeNode treeNode = null;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.setRight(node2);
        node2.setLeft(node3);

        for(int i = 0; i < arr.length; i++)
        {
            treeNode = bst.insertIntoBST(treeNode,arr[i]);
        }
        //bst.insertIntoBST(treeNode,5);
        TreeNode searchNode = bst.searchBST(treeNode,7);

        //bst.delete(2);
       // bst.delete(7);
        bst.deleteNode(treeNode,7);
        System.out.println(searchNode);
        System.out.println();

        ArrayList<Integer> integers = new ArrayList<>();
        inOrderTraverse(node1, integers);
        System.out.println(integers);


    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     String name;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
