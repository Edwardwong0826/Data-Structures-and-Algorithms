package com.wong.data_structures.nonlinear.tree;

public class BinarySearchTreeDemo
{

    public static void main(String[] args)
    {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for(int i = 0; i < arr.length; i++)
        {
            binarySearchTree.add(new Node(arr[i]));
        }

        binarySearchTree.inOrder(); //1,2,3,5,7,9,10,12

       //binarySearchTree.delete(2);
        binarySearchTree.delete(7);
//        binarySearchTree.delete(5);
//        binarySearchTree.delete(9);
//        binarySearchTree.delete(12);
//        binarySearchTree.delete(7);
//        binarySearchTree.delete(3);
//        binarySearchTree.delete(10);
//        binarySearchTree.delete(1);
        System.out.println();
        binarySearchTree.inOrder();
    }


}

class BinarySearchTree
{
    private Node root;

    public Node search(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.search(value);
        }
    }

    public Node searchParent(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.searchParent(value);
        }
    }

    // 1. return current node BST min node value
    // 2. delete node as root node BST min node
    public int delRightTreeMin(Node node)
    {
        Node target = node;

        // loop to find left node to get min value
        // because BST left node value will be smaller value than parent node
        while(target.left != null)
        {
            target = target.left;
        }

        delete(target.value);
        return target.value;
    }

    public int delLeftTreeMax(Node node)
    {
        Node target = node;

        // loop to find left node to get min value
        // because BST left node value will be smaller value than parent node
        while(target.right != null)
        {
            target = target.right;
        }

        delete(target.value);
        return target.value;
    }


    // Binary Search Tree delete node situation got three types
    // 1. the node that without any child
    // 2. the node with one child (left or right)
    // 3. the node with two child
    public void delete(int value)
    {
        if(root == null)
        {
            return;
        }
        else
        {

            Node targetNode = search(value);

            // didn't find wanted delete node
            if(targetNode == null)
            {
                return;
            }

            // when the BST only got one node
            if(root.left == null && root.right == null)
            {
                root = null;
                return;
            }

            Node parentNode = searchParent(value);
            // if delete node is leaf node
            if(targetNode.left == null && targetNode.right ==null)
            {
                // determine targetNode is parent node left or right node
                if(parentNode.left != null && parentNode.left.value == targetNode.value) // when left node
                {
                    parentNode.left = null;
                }
                else if(parentNode.right != null && parentNode.right.value == targetNode.value) // when right node
                {
                    parentNode.right = null;
                }
            }
            else if(targetNode.left != null && targetNode.right != null) // delete node with two tree
            {
                // this function will return delete targetNode right tree smallest node
                // in BST, node right tree smallest node value will greater than left tree biggest node value
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;

                // vice versa,in BST we also can get node left tree biggest node value and then delete
                //int maxVal = delLeftTreeMax(targetNode.left);
                //targetNode.value = maxVal;
            }
            else // delete node with one tree
            {
                // when delete node got only left node
                if(targetNode.left != null)
                {
                    if(parentNode != null)
                    {
                        //if targetNode is parent left node
                        if(parentNode.left.value == value)
                        {
                            parentNode.left = targetNode.left;
                        }
                        else if(parentNode.right.value == value) // if target node is parent right node
                        {
                            parentNode.right = targetNode.left;
                        }
                    }
                    else
                    {
                        root = targetNode.left;
                    }

                }
                else // when delete node got only right node
                {
                    if(parentNode != null)
                    {
                        //if targetNode is parent left node
                        if(parentNode.left.value == value)
                        {
                            parentNode.left = targetNode.right;
                        }
                        else if(parentNode.right.value == value) // if target node is parent right node
                        {
                            parentNode.right = targetNode.right;
                        }
                    }
                    else
                    {
                        root = targetNode.right;
                    }

                }
            }
        }
    }

    public void add(Node node)
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

    public void inOrder()
    {
        if(root != null)
        {
            root.inOrder();
        }
        else
        {
            System.out.println("Binary Search Tree is empty, cannot traverse");
        }
    }

}

class Node
{
    int value;
    Node left;
    Node right;

    public Node(int value)
    {
        this.value = value;
    }

    // return current node height
    public int height() {
        return Math.max(left == null? 0 : left.height(), right == null? 0 :right.height()) + 1;
    }

    // return left tree height
    public int leftHeight() {
        if(left == null)
            return 0;
        return left.height();
    }

    // return right tree height
    public int rightHeight() {
        if(right == null)
            return 0;
        return right.height();
    }

    public void leftRotate() {
        // create a new node based by current node value
        Node newNode = new Node(value);

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

    // use recursion way to add, and fulfill the BST requirement
    // 1. if add node value smaller than node, add to left
    // 2. else add node value greater than node, add to right
    // 3. if add node same value with the node, doesn't matter add to left or right
    public void add(Node node)
    {
        if(node == null)
        {
            return;
        }

        if(node.value < this.value)
        {
            if(this.left == null)
            {
                this.left = node;
            }
            else
            {
                // recursive add to left tree
                this.left.add(node);
            }
        }
        else
        {
            if(this.right == null)
            {
                this.right = node;
            }
            else
            {
                // recursive add to right tree
                this.right.add(node);
            }
        }

        // when after add node, if right tree height > left tree height more than 1, then left rotate
        if(rightHeight() - leftHeight() > 1) {
            leftRotate();
        }


    }

    public Node search(int value)
    {
        if(value == this.value)
        {
            return this;
        }
        else if(value < this.value)
        {
            if(this.left == null)
            {
                return null;
            }
            return this.left.search(value);
        }
        else
        {
            if(this.right == null)
            {
                return null;
            }
            return this.right.search(value);
        }

    }

    public Node searchParent(int value)
    {
        // if current node is delete node parent node, return it
        if(this.left != null && this.left.value == value ||
           this.right != null && this.right.value == value)
        {
            return this;
        }
        else
        {
            if(value < this.value && this.left != null)
            {
                return this.left.searchParent(value);
            }
            else if(value >= this.value && this.right != null)
            {
                return this.right.searchParent(value);
            }
            else
            {
                return null; // didn't find parent node
            }
        }
    }

    // inOrder traverse in Binary Search Tree will return ascending result
    public void inOrder()
    {
        if(this.left != null)
        {
            this.left.inOrder();
        }

        System.out.println(this);

        if(this.right != null)
        {
            this.right.inOrder();
        }
    }

    @Override
    public String toString()
    {
        return "Node" +
                "{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
