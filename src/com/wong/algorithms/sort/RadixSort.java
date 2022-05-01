package com.wong.algorithms.sort;

import java.util.Arrays;

public class RadixSort
{
        // radix sort cannot handle negative number
        public static void main(String[] args)
        {
            int[] arr = {53,3,542,748,14,214};
            int[] temp = new int[arr.length];
            //radixSort(arr);

            int[] arr2 = new int[8000000];
            for (int i=0; i< 8000000; i++)
            {
                arr2[i] = (int) (Math.random() * 8000000);
            }

            long tStart = System.currentTimeMillis();
            radixSort(arr2);

            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            double elapsedSeconds = tDelta / 1000.0;

            System.out.println(Arrays.toString(arr2));
            System.out.println(elapsedSeconds);
        }

        public static void radixSort(int[] arr)
        {
            int max = arr[0];
            for(int i=1; i<arr.length; i++)
            {
                if(arr[i]>max)
                {
                    max = arr[i];
                }
            }

            int maxLength = (max + "").length();

            for(int i=0, n = 1; i < maxLength; i++, n *= 10)
            {
                // radixSort is a classic algorithms use space to exchange time
                int[][] bucket = new int[10][arr.length];

                int[] bucketElementsCounts = new int[10];

                for(int j=0; j < arr.length; j++)
                {
                    int digitOfElement = arr[j] / n % 10;
                    bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = arr[j];
                    bucketElementsCounts[digitOfElement]++;
                }

                int index = 0;
                for(int k=0; k<bucketElementsCounts.length; k++)
                {
                    if(bucketElementsCounts[k] != 0)
                    {
                        for(int l=0;  l<bucketElementsCounts[k]; l++)
                        {
                            arr[index++] = bucket[k][l];

                        }

                    }

                    bucketElementsCounts[k] = 0;
                }

            }


        }

}
