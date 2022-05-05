package com.wong.data_structures.nonlinear.tree;

public class SequentialBinaryTreeDemo {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7};
        SequentialBinaryTree arrayBinaryTree = new SequentialBinaryTree(arr);
        //arrayBinaryTree.preOrder(0);
        //arrayBinaryTree.midOrder(0);
        arrayBinaryTree.postOrder(0);
    }

}

// write to implemented sequential storage binary tree
// heap sort will use this sequential storage binary tree
// 1. sequential storage binary tree is a completed binary tree
// 2. N element left node will be 2 * n + 1, n is 树得层数
// 3. N element right node will be 2 * n + 2
// 4. N element parent node will be (n-1) / 2
class SequentialBinaryTree
{
    private int[] arr;

    public SequentialBinaryTree(int[] arr)
    {
        this.arr = arr;
    }

    // sequential storage binary tree pre order traverse
    public void preOrder(int index)
    {
        if(arr == null || arr.length == 0)
        {
            System.out.println("empty array, cannot traverse by pre order");
        }
        System.out.println(arr[index]);
        if((index * 2 + 1) < arr.length)
        {
            preOrder(2*index+1);
        }

        if((index * 2 + 2) < arr.length)
        {
            preOrder(2*index+2);
        }

    }

    public void midOrder(int index)
    {
        if(arr == null || arr.length == 0)
        {
            System.out.println("empty array, cannot traverse by pre order");
        }

        if((index * 2 + 1) < arr.length)
        {
            midOrder(2*index+1);
        }

        System.out.println(arr[(index-1/2)]);

        if((index * 2 + 2) < arr.length)
        {
            midOrder(2*index+2);
        }

    }

    public void postOrder(int index)
    {
        if(arr == null || arr.length == 0)
        {
            System.out.println("empty array, cannot traverse by pre order");
        }

        if((index * 2 + 1) < arr.length)
        {
            postOrder(2*index+1);
        }

        if((index * 2 + 2) < arr.length)
        {
            postOrder(2*index+2);
        }


        System.out.println(arr[(index-1/2)]);

    }
}

