package com.wong.algorithms.sort;

import java.util.Arrays;

public class HeapSort
{
    // A Binary sort use a heap and Complete Binary Tree where items are stored in a special order such that the value in a parent node
    // is greater or smaller than the values in its two children node, max-heap or min-heap
    public static void main(String[] args)
    {
        int arr[] = {4,6,8,5,9};
        int[] arr2 = new int[8000000];
        for (int i=0; i< 8000000; i++)
        {
            arr2[i] = (int) (Math.random() * 8000000);
        }

        long tStart = System.currentTimeMillis();
        heapSort(arr2);
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
    }

    public static void heapSort(int[] arr)
    {
        int temp=0;
        for(int i = arr.length / 2-1; i >= 0; i--)
        {
            maxHeapify(arr,i, arr.length);
        }

        for(int j = arr.length-1; j > 0; j--)
        {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            maxHeapify(arr,0, j);
        }

        //System.out.println(Arrays.toString(arr));
    }

    // this function is to adjust k-th tree/non leaft node adjust to parent node > child node (max-heap as example)
    // i is non leaf node index in array
    // length is how many elements left continue to adjust, length should be decreasing
    // assume is from tree left to right, down to top
    public static void maxHeapify(int[]arr, int i, int length)
    {

        int temp = arr[i];
        // int l = 2 * i + 1; // left = 2 * i + 1
        // int r = 2 * i + 2; // right = 2 * i + 2

        for(int k = i * 2 + 1; k < length; k = k * 2 + 1)
        {
            if(k+1 < length && arr[k] < arr[k+1]) // if left node value < right node value
            {
                k++; // assign left node to become right node
            }
            if(arr[k] > temp) // if child node > parent node
            {
              arr[i] = arr[k]; // assign bigger child node value to parent node
              i = k; // let i point to k, because when swap it may still got tree, need continue loop and compare
            }
            else
            {
                break;
            }
        }

        // {4,6,8,5,9} before swap
        // {4,9,8,5,6} after swap
        arr[i] = temp; // assign parent node smaller value to left or right swap child node

    }
}
