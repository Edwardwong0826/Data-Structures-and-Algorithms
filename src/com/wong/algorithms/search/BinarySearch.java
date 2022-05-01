package com.wong.algorithms.search;

public class BinarySearch {


    public static void main(String[] args)
    {
        int arr[] = {1,8,10,89,1000,1234};
        int resultIndex = binarySearchRecursion(arr,0,arr.length-1,12);
        System.out.println(resultIndex);

    }

    public static int binarySearchRecursion(int[] arr, int left, int right, int findVal)
    {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(left>right)
        {
            return -1;
        }

        if(findVal > midVal)
        {
            return binarySearchRecursion(arr,mid+1,right,findVal);
        }
        else if(findVal < midVal)
        {
            return binarySearchRecursion(arr,left,mid-1,findVal);
        }
        else
        {
            return mid;
        }
    }

    public static int binarySearchIterative(int[] arr, int target)
    {

            if (arr == null || arr.length == 0) return -1;
            int left = 0;
            int right = arr.length - 1;

            while(left<=right)
            {
                int mid = left + (right - left) / 2;

                if(arr[mid] == target)
                    return mid;

                if(arr[mid] > target)
                    right = mid -1;
                else
                    right = mid + 1;
            }

            return -1;
    }

    public static int binarySearchUseInsertValue(int[]arr, int left, int right, int findVal)
    {
        // this is insert search algorithm
        // example arr = [1,2,3........,100]
        // int mid = 0 + (99-0) * (1-1) / (100-1) = 0 +99 * 0 / 99 = 0
        // few step can locate the search index already
        // this doesn't fit for data contains negative number

        if(left>right || findVal < arr[0] || findVal > arr[arr.length-1])
        {
            return -1;
        }

        int mid = left + (right-left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if(findVal > midVal)
        {
            return binarySearchUseInsertValue(arr,mid+1,right,findVal);
        }
        else if(findVal < midVal)
        {
            return binarySearchUseInsertValue(arr,left,mid-1,findVal);
        }
        else
        {
            return mid;
        }
    }

}
