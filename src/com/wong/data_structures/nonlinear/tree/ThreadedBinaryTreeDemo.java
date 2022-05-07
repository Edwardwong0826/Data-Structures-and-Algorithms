package com.wong.data_structures.nonlinear.tree;

public class ThreadedBinaryTreeDemo
{
    public static void main(String[] args)
    {
        tbtNode node1 = new tbtNode(1,"tom");
        tbtNode node2 = new tbtNode(3,"jack");
        tbtNode node3 = new tbtNode(6,"smith");
        tbtNode node4 = new tbtNode(8,"mary");
        tbtNode node5 = new tbtNode(10,"king");
        tbtNode node6 = new tbtNode(14,"dim");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        tree.threadedNodes(node1);

        //mid order traverse result = {8,3,10,1,14,6}
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


        System.out.println("Threaded way to traverse Threaded Binary Tree");
        tree.setRoot(node1);
        tree.threadedList();
    }
}

// Threaded Binary Tree is the tree that child node have null pointer pointing
// Idea of threaded binary trees is to make effectively manage the space and increase efficiency, when a binary tree consists of n nodes then n+1 link pointer contain NULL value
// N node have 2n-(n-1) = n+1 null pointer
// those N node null pointer use to point back to node in any order traverse, we called it 线索化
// by order traverse result, one node previous node call predecessor node, one node after node call successor node
// it may point to predecessor, successor, left tree or right tree
class ThreadedBinaryTree
{
    private tbtNode root;
    private tbtNode pre = null; // must have node point to previous node

    public void setRoot(tbtNode root)
    {
        this.root = root;
    }

    // traverse threaded tree by iterative
    public void threadedList()
    {
        tbtNode node = root;
        while (node != null)
        {
            //when lefttype ==1, means current node is 线索化 after handle effective node
            while(node.getLeftType() == 0)
            {
                node = node.getLeft();
            }
            System.out.println(node);
            // if current node right pointer is successor, keep output
            while(node.getRightType() == 1)
            {
                node = node.getRight();
                System.out.println(node);
            }
            // replace traverse node
            node = node.getRight(); // this actually is node.next.next when after found the right type is tree or 1,

        }
    }

    // here implemented 线索化
    public void threadedNodes(tbtNode node)
    {
        if(node == null)
        {
            return;
        }

        // mid order 线索化
        // 1. first 先线索化 left tree
        threadedNodes(node.getLeft());

        // 2. 线索化 current node
        // handle current node predecessor node
        // mid order traverse result = {8,3,10,1,14,6}
        // example by 8
        // node.left = null because 8 left right don't have result as above
        if(node.getLeft() == null)
        {

            node.setLeft(pre);  // let current node left pointer point to predecessor node
            node.setLeftType(1);; // change current node left type, 0 is tree, 1 is node, type might be null
        }

        //handle current node successor node
        if(pre != null && pre.getRight() == null)
        {
            pre.setRight(node);
            pre.setRightType(1);
        }

        // every time handle one node,let current node is next node predecessor node
        pre = node;

        // 3. 线索化 right tree
        threadedNodes(node.getRight());

    }

    private tbtNode addRecursive(tbtNode current, int value, String name)
    {

        if (current == null) {
            return new tbtNode(value, name);
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

    public tbtNode preOrderSearch(int no)
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

    public tbtNode midOrderSearch(int no)
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

    public tbtNode postOrderSearch(int no)
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


}

class tbtNode
{
    int no;
    String name;
    tbtNode left;
    tbtNode right;
    int leftType; // left type == 0 means point to left tree, if 1 point to predecessor
    int rightType;// right type == 0 means point to right tree, if 1 point to successor


    public tbtNode(int no, String name) {
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

    public tbtNode getLeft() {
        return left;
    }

    public void setLeft(tbtNode left) {
        this.left = left;
    }

    public tbtNode getRight() {
        return right;
    }

    public void setRight(tbtNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
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

    public tbtNode preOrderSearch(int no) {
        if(this.no == no) {
            return this;
        }
        tbtNode node = null;
        if(this.left != null) {
            node = this.left.preOrderSearch(no);
        }

        if(node != null) {
            return node;
        }

        if(this.right != null) {
            node = this.right.preOrderSearch(no);
        }

        return node;
    }

    public tbtNode midOrderSearch(int no) {

        tbtNode node = null;
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

    public tbtNode postOrderSearch(int no) {

        tbtNode node = null;
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
