package com.wong.data_structures.nonlinear.tree;

import com.sun.source.tree.Tree;

public class BinaryTree
{
    // binary tree got three types way, pre-order, middle order, post order to traverse the tree
    // 1. pre-order: first output parent node, then traverse left leaf and right leaf
    // 2. middle order: traverse left leaf, output parent node, then traverse right leaf
    // 3. post order: traverse left leaf, then traverse right leaf, finally output parent node
    // search by what order also follow as above

    private TreeNode root;

    public void setRoot(TreeNode root)
    {
        this.root = root;
    }

    private TreeNode addRecursive(TreeNode current, int value, String name) {

        if (current == null) {
            return new TreeNode(value, name);
        }

        if (value < current.no) {
            current.left = addRecursive(current.left, value, name);
        } else if (value > current.no) {
            current.right = addRecursive(current.right, value, name);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    public void add(int value, String name) {
        root = addRecursive(root, value, name);
    }

    public void delNode(int no)
    {
        if(root != null)
        {
            if(root.getNo() == no)
            {
                root = null;
            }
            else
            {
                root.delNode(no);
            }
        }
        else
        {
            System.out.println("Empty tree, cannot delete");
        }
    }

    public void preOrder()
    {
        if(this.root != null)
        {
            this.root.preOrder();
        }
        else
        {
            System.out.println("Binary tree is empty, cannot traverse");
        }
    }

    public void midOrder()
    {
        if(this.root != null)
        {
            this.root.midOrder();
        }
        else
        {
            System.out.println("Binary tree is empty, cannot traverse");
        }
    }

    public void postOrder()
    {
        if(this.root != null)
        {
            this.root.postOrder();
        }
        else
        {
            System.out.println("Binary tree is empty, cannot traverse");
        }
    }

    public TreeNode preOrderSearch(int no)
    {
        if(root != null)
        {
            return root.preOrderSearch(no);
        }
        else
        {
            return null;
        }

    }

    public TreeNode midOrderSearch(int no)
    {
        if(root != null)
        {
            return root.midOrderSearch(no);
        }
        else
        {
            return null;
        }

    }

    public TreeNode postOrderSearch(int no)
    {
        if(root != null)
        {
            return root.postOrderSearch(no);
        }
        else
        {
            return null;
        }

    }


    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode1 = new TreeNode(1,"Song Jiang");
        TreeNode treeNode2 = new TreeNode(2,"Wu Yong");
        TreeNode treeNode3 = new TreeNode(3,"Lu Ju Yi");
        TreeNode treeNode4 = new TreeNode(4,"Lin Chong");
        TreeNode treeNode5 = new TreeNode(5,"Guan Sheng");

        // first manually create binary tree, later use recursion way to create
        binaryTree.setRoot(treeNode1);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode5);
        treeNode3.setRight(treeNode4);


//        binaryTree.add(1,"Song Jiang");
//        binaryTree.add(2,"Wu Yong");
//        binaryTree.add(3,"Lu Ju Yi");
//        binaryTree.add(4,"Lin Chong");
//        binaryTree.add(5,"Guan Sheng");

        System.out.println("preOrder: "); // 1,2,3,5,4
        binaryTree.preOrder();

        System.out.println("midOrder: "); // 2,1,5,3,4
        binaryTree.midOrder();

        System.out.println("postOrder: "); // 2,5,4,3,1
        binaryTree.postOrder();

        // pre order need 4 times, mid order 3 times, post order 2 times
        System.out.println("-----------------------------");
        System.out.println(binaryTree.preOrderSearch(4));
        System.out.println(binaryTree.midOrderSearch(5));
        System.out.println(binaryTree.postOrderSearch(6));

    }
}


class TreeNode
{
    int no;
    String name;
    TreeNode left;
    TreeNode right;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no) {

        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if(this.left != null) {
            this.left.delNode(no);
        }

        if(this.right != null) {
            this.right.delNode(no);
        }

    }

    public void preOrder() {

        System.out.println(this);

        if(this.left != null)
            this.left.preOrder();
        if(this.right != null)
            this.right.preOrder();

    }

    public void midOrder() {

        if(this.left != null)
            this.left.midOrder();

        System.out.println(this);

        if(this.right != null)
            this.right.midOrder();

    }

    public void postOrder() {

        if(this.left != null)
            this.left.postOrder();
        if(this.right != null)
            this.right.postOrder();


        System.out.println(this);
    }

    public TreeNode preOrderSearch(int no) {
        if(this.no == no) {
            return this;
        }
        TreeNode node = null;
        if(this.left != null) {
            node = this.left.preOrderSearch(no);
        }

        if(node != null) {
            return node;
        }

        if(this.right != null) {
            node = this.right.preOrderSearch(no);
        }

        return  node;
    }

    public TreeNode midOrderSearch(int no) {

        TreeNode node = null;
        if(this.left != null) {
            node = this.left.midOrderSearch(no);
        }

        if(node != null) {
            return node;
        }

        if(this.no == no) {
            return this;
        }

        if(this.right != null) {
            node = this.right.midOrderSearch(no);
        }

        return node;
    }

    public TreeNode postOrderSearch(int no) {

        TreeNode node = null;
        if(this.left != null) {
            node = this.left.postOrderSearch(no);
        }

        if(node != null) {
            return node;
        }

        if(this.right != null) {
            node = this.right.postOrderSearch(no);
        }

        if(node != null) {
            return node;
        }

        if(this.no == no) {
            return this;
        }

        return node;
    }
}
