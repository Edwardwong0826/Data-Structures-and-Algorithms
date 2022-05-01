package com.wong.algorithms.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args)
    {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        //sort(arr);

        int[] arr2 = new int[80000];
        for (int i=0; i< 80000; i++)
        {
            arr2[i] = (int) (Math.random() * 8000000);
        }

       sort2(arr2);

    }

    // slow version using交换法
    public static void sort(int[] arr)
    {
        long tStart = System.currentTimeMillis();
        int temp=0;
        for(int gap = arr.length/2; gap>0; gap/= 2  )
        {

            // split the data to 5 group
            for(int i =gap; i< arr.length; i++)
            {
                // example if i = 5
                // it will divide by 2, example arr.length is 10 which be become 5 groups
                // why j=j-5 is because i start from 5, it will i++; so when i =6
                // here j is 6-5, which is 1
                for(int j=i-gap; j>=0 ; j -= gap)
                {
                    if(arr[j] > arr[j+gap])
                    {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }

            }


        }
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        System.out.println(Arrays.toString(arr));
        System.out.println(elapsedSeconds);
    }

    // fast version using移位法
    public static void sort2(int[] arr)
    {
        long tStart = System.currentTimeMillis();

        for(int gap = arr.length/2; gap>0; gap/= 2  )
        {

            // split the data to n group
            for(int i =gap; i< arr.length; i++)
            {
                int j =i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap])
                {
                    while(j-gap >= 0 && temp < arr[j-gap])
                    {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

            }


        }
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        System.out.println(Arrays.toString(arr));
        System.out.println(elapsedSeconds);
    }
}
