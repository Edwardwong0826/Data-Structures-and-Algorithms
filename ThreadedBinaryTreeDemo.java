package com.wong.data_structures.nonlinear.tree;

public class ThreadedBinaryTreeDemo
{
    public static void main(String[] args)
    {
        Node node1 = new Node(1,"tom");
        Node node2 = new Node(3,"jack");
        Node node3 = new Node(6,"smith");
        Node node4 = new Node(8,"mary");
        Node node5 = new Node(10,"king");
        Node node6 = new Node(14,"dim");

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
    private Node root;
    private Node pre = null; // must have node point to previous node

    public void setRoot(Node root)
    {
        this.root = root;
    }

    // traverse threaded tree by iterative
    public void threadedList()
    {
        Node node = root;
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
    public void threadedNodes(Node node)
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

    private Node addRecursive(Node current, int value, String name)
    {

        if (current == null) {
            return new Node(value, name);
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

    public Node preOrderSearch(int no)
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

    public Node midOrderSearch(int no)
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

    public Node postOrderSearch(int no)
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

class Node
{
    int no;
    String name;
    Node left;
    Node right;
    int leftType; // left type == 0 means point to left tree, if 1 point to predecessor
    int rightType;// right type == 0 means point to right tree, if 1 point to successor


    public Node(int no, String name) {
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
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

    public Node preOrderSearch(int no) {
        if(this.no == no) {
            return this;
        }
        Node node = null;
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

    public Node midOrderSearch(int no) {

        Node node = null;
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

    public Node postOrderSearch(int no) {

        Node node = null;
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
