package com.wong.data_structures.nonlinear.tree;

class BST
{
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

    public static void main(String[] args)
    {
        int[] arr = {4,2,7,1,3};
        BST bst = new BST();
        TreeNode treeNode = null;

        for(int i = 0; i < arr.length; i++)
        {
            treeNode = bst.insertIntoBST(treeNode,arr[i]);
        }
        bst.insertIntoBST(treeNode,5);
        TreeNode searchNode = bst.searchBST(treeNode,5);

        //bst.delete(2);
       // bst.delete(7);
        System.out.println();
        System.out.println(searchNode);

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
