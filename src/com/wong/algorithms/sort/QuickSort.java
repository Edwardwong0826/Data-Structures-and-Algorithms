package com.wong.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    // Quicksort is an improvement for Bubblesort, it split data to 2 groups,
    // one of the group data will be smaller to other group, and will sort based on this two group using recursion
    public static void main(String[] args)
    {
        int[] arr = {-9,78,0,23,-567,70};
        //sort(arr);

        int[] arr2 = new int[8000000];
        for (int i=0; i< 8000000; i++)
        {
            arr2[i] = (int) (Math.random() * 8000000);
        }

        long tStart = System.currentTimeMillis();
        
        sortArray(arr2);

        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
    }

    public static List<Integer> sortArray(int[] nums)
    {

        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        quickSort(nums, 0, nums.length - 1);

        for (int i : nums)
            res.add(i);

        return res;

    }
    private static void quickSort(int[] nums, int l, int r)
    {

        if (l >= r) return;
        int mid = partition(nums, l, r);

        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);

    }
    private static int partition(int[] nums, int l, int r)
    {

        int pivot = nums[l];
        while (l < r)
        {

            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];

        }

        nums[l] = pivot;
        return l;

    }

}
