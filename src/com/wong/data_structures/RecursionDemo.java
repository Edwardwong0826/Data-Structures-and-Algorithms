package com.wong.data_structures.linear.recursion;

public class RecursionDemo {

    // Recursion use in many algorithms, such a quick sort, merge sort, binary search, divide and conquer
    // it must have a base case to terminate, otherwise it will keep recurse forever
    // A set of rules, also known as recurrence relation that reduces all other cases towards the base case.
    // However, it might bring some undesired penalty to the performance, e.g. duplicate calculations,
    // We can propose a common technique called memoization that can be used to avoid duplicate calculations.

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        recursion(0, s.length-1 ,s);

        for(char c: s){
            System.out.println(c);
        }

        System.out.println(fibonacciNumber(4));

    }

    private static void recursion(int i, int j, char[] s) {
        if(s == null || i > j) {
            return;
        }

        char temp = s[i];

        s[i] = s[j];
        s[j] = temp;

        recursion(i+1, j-1, s);

    }

    public static int fibonacciNumber(int n) {
        if(n <= 1){
            return n;
        }
        else {
            return fibonacciNumber(n-1) + fibonacciNumber(n-2) ;
        }

    }

}
