package com.wong.algorithms.sort;

import java.util.Arrays;

public class BubbleSorting {

    public static void sortAscending(int[] number) {

        for(int i = 0 ; i < number.length ; i++){
            int count=0;
            // move the bigger num to back
            for(int j = 0 ; j < number.length-i-1; j++){

                int temp;

                if(number[j] > number[j+1]){
                    temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                    count++;
                }
            }

            // if the count is -, means this num is already order sort, thus can directly break out the loop;
            if(count == 0)
                break;
        }

        System.out.println(Arrays.toString(number));
    }

    public static String sortChar(char[] chars) {

        for(int i = 0 ; i < chars.length ; i++){
            int count=0;
            // move the bigger num to back
            for(int j = 0 ; j < chars.length-i-1; j++){

                char temp;

                if(chars[j] > chars[j+1]){
                    temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                    count++;
                }
            }

            // if the count is -, means this num is already order sort, thus can directly break out the loop;
            if(count == 0)
                break;
        }

        System.out.println(Arrays.toString(chars));
        return Arrays.toString(chars);
    }


    // time complexity = o(n)
    public static void main(String[] args){
        int[] number = {2,0,2,1,1,0};
        String s1 = "anagram";
        String s2 = "nagaram";

        BubbleSorting.sortAscending(number);
        String sort1 = sortChar(s1.toCharArray());
        String sort2 = sortChar(s2.toCharArray());

        if(sort1.equals(sort2)){
            System.out.println(true);
        }

    }
}
