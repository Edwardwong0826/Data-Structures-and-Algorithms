package com.wong;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("HelloWorld!!!");

        int[] nums = {1,1,2};
        int[] nums2 = {3,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeElement(nums2,3));
    }


    // Leetcode question and submitted solution
    // Question 26 Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {

        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;

    }

    //Question 27 Remove Element
    public static int removeElement(int[] nums, int val) {
        int i = 0;

        for (int n : nums){
            if (n != val)
                nums[i++] = n;
        }

        return i;
    }

    // Qustion 34 Find First and Last Position of Element in Sorted Array - binary search and array
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = { -1, -1 };
        if (nums.length == 0) {
            return ans;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                //这里是为了处理 mid - 1 越界的问题，可以仔细想下。
                //如果 mid == 0，那么 mid 一定是我们要找的了，而此时 mid - 1 就会越界了，
                //为了使得下边的 target > n 一定成立，我们把 n 赋成最小值
                //如果 mid > 0，直接吧 nums[mid - 1] 赋给 n 就可以了。
                int n = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
                if (target > n) {
                    ans[0] = mid;
                    break;
                }
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                int n = mid < nums.length - 1 ? nums[mid + 1] : Integer.MAX_VALUE;
                if (target < n) {
                    ans[1] = mid;
                    break;
                }
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> prefix, int startAt) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(prefix));
        } else {
            for (int i = startAt; i < candidates.length; i++) {
                prefix.add(candidates[i]);
                // todo bug: do not start at i + 1, because we can reuse same elements
                backtrack(result, candidates, target - candidates[i], prefix, i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    //Question 53 Maximum Subarray - Kadane's Algorithm - iterative DP
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum < 0)
                sum = 0;
        }
        return max;
    }

    // Question 41 First Missing Positive - array
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //遍历每个数字
        for (int i = 0; i < n; i++) {
            //判断交换回来的数字
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                //第 nums[i] 个位置的下标是 nums[i] - 1
                swap(nums, i, nums[i] - 1);
            }
        }
        //找出第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果之前的数都满足就返回 n + 1
        return n + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Question 108 Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] arr) {

        if(arr == null)
            return null;

        return bst(arr, 0, arr.length-1);
    }

    public TreeNode bst(int[]arr, int left, int right){
        if(left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = bst(arr, left, mid-1);
        node.right = bst(arr, mid+1, right) ;

        return node;

    }

    // Question 136 Single number - use xor bitwise to find non duplicate digit
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int x: nums){
            result = result ^ x;
        }
        return result;
    }

    // Question 167 Two Sum II - Input Array Is Sorted - binary search
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(numbers[start] == (target - numbers[end]))
                return new int[]{start + 1, end + 1};
            else if (numbers[start] + numbers[end] < target) {
                // 运用在这里 注意==的时候 是一步步走的 否则会错过
                start = (numbers[mid] + numbers[end] < target) ? mid + 1 : start + 1;
            }else{
                end = (numbers[start] + numbers[mid] > target) ? mid + 1 : end - 1;
            }
        }
        return new int[]{-1,-1};
    }


    // Question 547 Number of Provinces - graph DFS
    public int findCircleNum(int[][] isConncted) {
        int[] isVisited = new int[isConncted.length];
        int count = 0;
        for (int i = 0; i < isConncted.length; i++) {
            if (isVisited[i] == 0) {
                dfs(isConncted, isVisited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConncted, int[] isVisited, int i) {
        for (int j = 0; j < isConncted.length; j++) {
            if (isConncted[i][j] == 1 && isVisited[j] == 0) {
                isVisited[j] = 1;
                dfs(isConncted, isVisited, j);
            }
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
