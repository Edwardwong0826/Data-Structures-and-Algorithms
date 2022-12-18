package com.wong;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println("HelloWorld!!!");
//
//        int[] nums = {1,1,2};
//        int[] nums2 = {3,2,2,3};
//        System.out.println(removeDuplicates(nums));
//        System.out.println(removeElement(nums2,3));
//        lengthOfLastWord("Hello World ");
//
//        System.out.println(isEvenNumber(1));
//
//
//        ListNode node4 = new ListNode(3);
//        ListNode node3 = new ListNode(1,node4);
//        ListNode node2 = new ListNode(2,node3);
//        ListNode node1 = new ListNode(4,node2);
//
//        Main main = new Main();
//        ListNode node = main.sortList(node1);
//        System.out.println(node);

    }


    // LeetCode question and submitted solution
    // String catogery problem

    // Question 14 Longest common prefix - string
    public static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        int i = 1;

        while(i < strs.length){

            while(strs[i].indexOf(prefix) != 0){ // indexOf return -1 if not found
                prefix = prefix.substring(0, prefix.length()-1);
            }
            i++;
        }

        return prefix;
    }

    // Question 17 Letter Combinations of a Phone Number - BFS solution
    public static List<String> letterCombinations() {

        String digits = "23";

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");


        for(char digit : digits.toCharArray())
        {

            String currentLetter = letters[digit-'2'];
            List<String> newResult = new ArrayList<>();

            for(String item : result)
            {
                for(char character: currentLetter.toCharArray() )
                {
                    newResult.add(item + character);
                }
            }

            result = newResult;

        }

        return result;
    }

    // Question 28 Find the Index of the First Occurrence in a String
    public static int strStr(String haystack, String needle) {

        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        else{
            return -1;
        }
    }

    // Question 58 Length of Last Word
    public static int lengthOfLastWord(String s)
    {
        s = s.trim();
        char[] word = s.toCharArray();
        int length = 0;

        for(int i = s.length()-1; i >0; i--)
        {
            if(word[i] == ' ')
            {
                break;
            }
            else if(!(word[i] == ' '))
            {
                length++;
            }


        }

        return length;
    }

    // Question 139 Word Break - Hash Table and Memoization solution
    static HashMap<String, Boolean> map = new HashMap<>();
    public static boolean wordBreak(String s, List<String> wordDict) {

        if(wordDict.contains(s))
            return true;
        if(map.containsKey(s))
            return map.get(s);

        for(int i=0; i<s.length(); i++) {
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);

            if(wordDict.contains(prefix) && wordBreak(suffix, wordDict)) {
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }

    // Quetion 151 Reverse Words in String
    public static String reverseWords(String s) {

        String[] word = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = word.length-1; i>=0; i--){
            if(!word[i].equals("")){
                sb.append(word[i]).append(" ");
            }
        }

        return sb.toString().trim();

    }

    // Question 567 Permutation in String
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    // Question 680 Valid Palindrome II
    public static boolean validPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;

    }

    private static boolean isPalindrome(String s, int i, int j)
    {
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // Array category problem

    // Question 26 Remove Duplicates from Sorted Array - String
    public static int removeDuplicates(int[] nums) {

        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;

    }

    // Question 27 Remove Element - String
    public static int removeElement(int[] nums, int val) {
        int i = 0;

        for (int n : nums){
            if (n != val)
                nums[i++] = n;
        }

        return i;
    }


    // Question 34 Find First and Last Position of Element in Sorted Array - binary search and array
    public static int[] searchRange(int[] nums, int target) {
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

    // Question 39 Combination Sum - back track solution
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

    // Question 41 First Missing Positive - array
    public static int firstMissingPositive(int[] nums) {
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

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Question 49 Group Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);

            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());

    }

    // Question 53 Maximum SubArray - Kadane's Algorithm - iterative DP
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum < 0)
                sum = 0;
        }
        return max;
    }

    // Question 128 Longest Consecutive Sequence
    public static int longestConsecutive()
    {
        int nums[] = {100,4,200,1,3,2};
        int max = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;

    }

    // Question 136 Single number - use xor bitwise to find non-duplicate digit
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int x: nums){
            result = result ^ x;
        }
        return result;
    }

    // Question 167 Two Sum II - Input Array Is Sorted - binary search
    public static int[] twoSum(int[] numbers, int target) {
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

    // Question 179 Largest Number
    public String largestNumber(int[] nums) {

        String[] numStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            numStr[i] = String.valueOf(nums[i]);
        // Integer.toString(nums[i]) is slower
        // Arrays.sort(numStr, (o1, o2) -> (o2.concat(o1)).compareTo(o1.concat(o2)));
        // lambda is much slower
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2, s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        if (numStr[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder(); // use StringBuilder to concact
        for (String str : numStr) res.append(str);

        return res.toString();

    }

    // Question 187 Repeated DNA Sequences - hash table
    public List<String> findRepeatedDnaSequences(String s) {

        HashMap<String, Integer> sequence = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i < s.length(); i++){

            if(!(i+10 > s.length())){

                if(!sequence.containsKey(s.substring(i, i+10))) {
                    sequence.put(s.substring(i, i+10), 0);
                }
                else{
                    int updateValue = sequence.get(s.substring(i, i+10)) + 1;
                    sequence.put(s.substring(i, i+10), updateValue);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : sequence.entrySet()) {
            if(entry.getValue() > 0){
                result.add(entry.getKey());
            }
        }

        return result;

    }

    // Question 344 Reverse String - String, Recursion
    public void reverseString(char[] s) {
        recursion(0, s.length-1, s);

    }

    private static void recursion(int i, int j, char[] s) {
        if(i > j || s == null)
            return;

        char temp = s[j];

        s[j] = s[i];
        s[i] = temp;

        recursion(i+1, j-1, s);
    }

    // Question 747 Largest Number At Least Twice of Others - Array, Sorting
    public static int dominantIndex(int[] nums) {

        if(nums.length == 1)
            return 0;

        int i = 0;
        int tmp = 0;
        int tmp2 = 0;

        for(int k=0; k<nums.length;k++){

            if(tmp < nums[k])
            {
                tmp = nums[k];
                i = k;
            }

        }

        for(int l=0; l<nums.length;l++){

            if(tmp2 < nums[l] && nums[l] != nums[i] )
            {
                tmp2 = nums[l];
            }
        }


        if( tmp >= (tmp2 * 2) )
        {
            return i;
        }
        else
        {
            return -1;
        }
    }

    // Sorting category problem


    // Question 148 Insertion Sort List - Linked List, Two Pointers
    public ListNode insertionSortList(ListNode head) {

        if( head == null ){
            return head;
        }

        ListNode temp = new ListNode(0);
        ListNode current = head;
        ListNode previous = temp;
        ListNode next = null;

        while( current != null ){
            next = current.next;

            while( previous.next != null && previous.next.val < current.val ){
                previous = previous.next;
            }

            current.next = previous.next;
            previous.next = current;
            previous = temp;
            current = next;
        }

        return temp.next;
    }

    // Question 148 Sort List - Two pointers, Divide and Conquer, Sorting, Merge Sort
    public static ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    static ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode l = new ListNode(0);
        ListNode p = l;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    // Question 215 Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        quickSort(nums, 0, nums.length - 1);

        for(int i : nums)
            res.add(i);

        return res.get(res.size()-k);
    }


    private void quickSort(int[] nums, int l, int r)
    {

        if (l >= r) return;
        int mid = partition(nums, l, r);

        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);

    }
    private int partition(int[] nums, int l, int r)
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


    // Binary Tree, Binary Search Tree, Binary Search category problem

    // Question 94 Binary Tree inorder Traversal - DFS, tree
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preHelper(root,pre);
        return pre;
    }
    public static void preHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        preHelper(root.left,pre);
        pre.add(root.val);
        preHelper(root.right,pre);

    }

    // Question 98 Validate Binary Search Tree
    public static boolean isValidBST(TreeNode root)
    {
        return search(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean search(TreeNode root, long minVal, long maxVal)
    {
        if(root == null)
            return true;

        if(root.val <= minVal)
            return false;

        if(root.val >= maxVal)
            return false;

        return search(root.left, minVal, root.val) && search(root.right, root.val, maxVal);
    }

    // Question 105 Construct Binary Tree from Preorder and Inorder Traversal - Binary Tree
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    // Question 108 Convert Sorted Array to Binary Search Tree - BST
    public static TreeNode sortedArrayToBST(int[] arr) {

        if(arr == null)
            return null;

        return bst(arr, 0, arr.length-1);
    }

    public static TreeNode bst(int[]arr, int left, int right){
        if(left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(arr[mid]);

        node.left = bst(arr, left, mid-1);
        node.right = bst(arr, mid+1, right) ;

        return node;

    }


    // Question 222 Count Complete Tree Nodes - DFS, binary search
    public static int countNodes(TreeNode root) {

        if(root != null)
            return countNodes(root.left) + countNodes(root.right) + 1;

        return 0;

    }

    // Question 230 Kth Smallest Element in a BST - BST, DFS
    public static int kthSmallest(TreeNode root, int k)
    {
        int [] count = new int[]{0};
        int [] result = new int[]{0};
        findSmallest(root,k,count,result);
        return result[0];
    }

    public static void findSmallest(TreeNode root, int k, int[] count, int[] result)
    {
        if(root == null)
            return;

        findSmallest(root.left, k, count, result);

        count[0]++;
        if(count[0] == k)
        {
            result[0] = root.val;

        }

        findSmallest(root.right, k, count, result);

    }

    // Question 236 Lowest Common Ancestor of a Binary Tree - Binary Tree, DFS
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        else
            return left != null? left : right;

    }

    // Question 543 Diameter of Binary Tree - Binary Tree, DFS
    static int max=0;

    public static int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return max;

    }

    private static int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left+right);

        return Math.max(left, right)+1;

    }

    // Question 704 Binary Search - Binary Search
    public static int search(int[] nums, int target)
    {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    static int binarySearch(int[]nums, int target, int left, int right )
    {

        if(left > right)
            return -1;

        int mid = (left + right) / 2;

        if(target == nums[mid])
        {
            return mid;
        }

        if(nums[mid] > target)
        {
            return binarySearch(nums, target, left, mid-1);
        }

        return binarySearch(nums, target, mid+1, right);
    }

    // Others category problem

    public static boolean isEvenNumber(int n){
        return (n & 1) == 0; // in java can use n & 1 and then evaluate is it equal to 0 to determine is even(or negative odd)
    }

    // Question 24 Swap Nodes in Paris - Linked List, Recursion
    public ListNode swapPairs(ListNode head) {

        if ((head == null)||(head.next == null))
            return head;

        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;

        return node;
    }

    // Question 146 LRU Cache
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    class LRUCache {

        HashMap<Integer,Node> map=new HashMap<>();
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        int capacity;

        public LRUCache(int capacity) {
            this.capacity=capacity;
            head.next=tail;
            tail.prev=head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node=map.get(key);
                delete(node);
                insert(node);
                return node.value;
            }
            else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                delete(map.get(key));
            }
            if(map.size()>=capacity){
                delete(tail.prev);
            }
            insert(new Node(key,value));
        }
        public void insert(Node node){
            map.put(node.key,node);
            Node headNext=head.next;
            head.next=node;
            node.prev=head;
            headNext.prev=node;
            node.next=headNext;
        }
        public void delete(Node node){
            map.remove(node.key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
    }

    // Question 231 Power of two - bit wise manipulation
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    // Question 342 power of four - recursion
    public static boolean isPowerOfFour(int n) {
        if(n <= 1)
            return n == 1;
        return n % 4 == 0 && isPowerOfFour(n / 4);
    }

    // Question 547 Number of Provinces - graph DFS
    public static int findCircleNum(int[][] isConnected) {
        int[] isVisited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isVisited[i] == 0) {
                dfs(isConnected, isVisited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] isConncted, int[] isVisited, int i) {
        for (int j = 0; j < isConncted.length; j++) {
            if (isConncted[i][j] == 1 && isVisited[j] == 0) {
                isVisited[j] = 1;
                dfs(isConncted, isVisited, j);
            }
        }
    }


    // Question 1295 Find Numbers with Even Number of Digits
    public static int findNumbers(int[] nums) {
        int result = 0;

        for(int i = 0 ; i < nums.length ; i++){

            int count = (int)Math.log10(nums[i]) + 1; //example (234 log 10 + 1) = ( 2 + 1 ) = 3 - number of digit

            if(count % 2 == 0) result++;
        }

        return result;
    }

}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
