package com.wong;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args)
    {

        //System.out.println(twice(new int[]{1,0}));
        String s1 = "ab";
        String s2 = "eidbaooo";

        HashMap<String,Integer> map = new HashMap<String, Integer>();


    }

    public static int twice(int[] nums){

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


        if( tmp > (tmp2 * 2) || tmp == (tmp2 * 2) )
        {
            return i;
        }
        else
        {
            return -1;
        }

    }
}
