package com.wong.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] number){
        for(int i=0 ; i<number.length-1; i++)
        {
            int index = i;
            int temp=number[i];

            for(int j = i+1 ; j <= number.length-1; j++)
            {

                if(temp > number[j])
                {
                    // get the smaller number
                    // get the loop min number index
                    temp = number[j];
                    index = j;
                }


            }

                // swap with min number index in array
                number[index] = number[i];
                number[i] = temp;


        }

        System.out.println(Arrays.toString(number));
    }

    // time complexity = o(n)
    public static void main(String[] args)
    {
        int[] number = {2,0,2,1,1,0};
        SelectionSort.sort(number);
    }
}
