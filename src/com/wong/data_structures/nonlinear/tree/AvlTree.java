package com.wong.data_structures.nonlinear.tree;

public class AvlTree extends BinarySearchTree{
    private AVvlNode root;
    // AVL tree also called self-balancing tree, is a binary search tree that optimise that efficiency of traverse operations
    // by rotate the left tree or right tree, when either tree height is > 1, AVL must be empty tree or both tree height cannot > 1

//    public int height(TreeNode root) {
//        return Math.max(root.left == null ? 0 : root.left.height(), root.right == null ? 0 : root.right.height()) + 1;
//    }
//
//    public int leftHeight(TreeNode root) {
//        if(root == null)
//            return 0;
//        return height(root.left);
//    }
//
//    public int rightHeight(TreeNode root) {
//        if(root == null)
//            return 0;
//        return height(root.right);
//
//    }

    public void add(AVvlNode node)
    {
        if(root == null)
        {
            root = node;
        }
        else
        {
            root.add(node);
        }

    }

    @Override
    public void inOrder()
    {
        if(root != null)
        {
            root.inOrder();
        }
        else
        {
            System.out.println("AVL Search Tree is empty, cannot traverse");
        }
    }

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        int[] arr2 = {10,12,8,9,7,6};
        AvlTree avlTree = new AvlTree();
        for(int i = 0; i < arr2.length; i++)
        {
            avlTree.add(new AVvlNode(arr2[i]));
        }

        avlTree.inOrder();
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());
        System.out.println();

        // below is after add, and rotate the root tree accordingly
        System.out.println(avlTree.root.value);
        System.out.println(avlTree.root.left);


    }
}

class AVvlNode {

    int value;
    AVvlNode left;
    AVvlNode right;

    public AVvlNode(int value) {
        this.value = value;
    }

    // return current node height
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // return left tree height
    public int leftHeight() {
        if (left == null)
            return 0;
        return left.height();
    }

    // return right tree height
    public int rightHeight() {
        if (right == null)
            return 0;
        return right.height();
    }

    public void leftRotate() {
        // create a new node based by current node value
        AVvlNode newNode = new AVvlNode(value);

        // set new node left tree by current node left tree
        newNode.left = this.left;

        // set new node right tree by current node left tree->right tree
        newNode.right = this.right.left;

        // set current value as right node value
        value = this.right.value;

        // set current node right tree by current node right tree -> right tree
        right = this.right.right;

        // set current node left tree as new node
        left = newNode;
    }

    public void rightRotate() {
        // create a new node based by current node value
        AVvlNode newNode = new AVvlNode(value);

        // set new node right tree by current node right tree
        newNode.right = this.right;

        // set new node left tree by current node right tree->left tree
        newNode.left = this.left.right;

        // set current value as left node value
        value = this.left.value;

        // set current node left tree by current node left tree -> left tree
        left = this.left.left;

        // set current node right tree as new node
        right = newNode;
    }

    // use recursion way to add, and fulfill the BST requirement
    // 1. if add node value smaller than node, add to left
    // 2. else add node value greater than node, add to right
    // 3. if add node same value with the node, doesn't matter add to left or right
    public void add(AVvlNode node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                // recursive add to left tree
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                // recursive add to right tree
                this.right.add(node);
            }
        }

//        if(right != null && right.leftHeight() > right.rightHeight()){
//            // first right rotate its child right tree
//            right.rightRotate();
//            leftRotate();
//        }
//        else{
//            leftRotate();
//        }
//
//        return;

        // when after add node, if right tree height > left tree height more than 1, then left rotate
        if (rightHeight() - leftHeight() > 1) {

            //if its child right tree -> left tree larger than right tree -> right tree height
            if(right != null && right.leftHeight() > right.rightHeight()){
                // first right rotate its child right tree
                right.rightRotate();

            }
                leftRotate();
        }

        // when we want to right rotate
        // 1. if current node left tree -> right tree height higher than current node left tree -> left tree
        // 2. then we first left rotate current node left tree
        // 3. last continue right rotate at current node
        if (leftHeight() - rightHeight() > 1) {

            //if its child left tree -> right tree larger than left tree -> left tree height
            if(left != null && left.rightHeight() > left.leftHeight()) {
                // first left rotate its child left tree
                left.leftRotate();

            }
                rightRotate(); // this is rotate for current node

        }

    }

    public AVvlNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }

    public AVvlNode searchParent(int value) {
        // if current node is delete node parent node, return it
        if (this.left != null && this.left.value == value ||
                this.right != null && this.right.value == value) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null; // didn't find parent node
            }
        }
    }

    // inOrder traverse in Binary Search Tree will return ascending result
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.inOrder();
        }
    }

    @Override
    public String toString() {
        return "Node" +
                "{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
