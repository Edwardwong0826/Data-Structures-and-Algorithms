package com.wong.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    // Mergesort use divide and conquer strategy to divide problem in to smaller problem
    // and then recursion to solve it
    public static void main(String[] args)
    {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        //mergeSort(arr,0,arr.length-1, temp);

        int[] arr2 = new int[8000000];
        for (int i=0; i< 8000000; i++)
        {
            arr2[i] = (int) (Math.random() * 8000000);
        }

        long tStart = System.currentTimeMillis();
        mergeSort(arr2,0,arr.length-1, temp);

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(Arrays.toString(arr2));
        System.out.println(elapsedSeconds);
    }
    public static void mergeSort(int[]arr, int left, int right, int[] temp) {

        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp)
    {
        int i = left;  // init left index
        int j = mid + 1; // init right index
        int t = 0; // for temp array current index

        // fill in both array data according rules to temp array
        // until end of any one side of order array
        while(i <= mid && j <= right)
        {
            if(arr[i] <= arr[j])
            {
                //temp[t++] = arr[i++];
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }
            else
            {
                //temp[t++] = arr[j++];
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // copy remain array data to the temp
        while( i <= mid)
        {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while( j <= right)
        {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // copy temp to arr
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right)
        {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft +=1;
        }
    }
}
