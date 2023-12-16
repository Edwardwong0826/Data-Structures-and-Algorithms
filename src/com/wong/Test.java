package com.wong;

import java.util.*;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("first");
        //System.out.println(removeDigit("-5958", '5'));

        List<String> list = new ArrayList<>();
        list.add("code");
        list.add("doce");
        list.add("ecod");
        list.add("framer");
        list.add("frame");

        List<String> answer = new ArrayList<>();

        List<String> duplicate = new ArrayList<>();

        for(String s : list){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);

            if(!duplicate.contains(str)){
                duplicate.add(str);
                answer.add(s);
            }
        }

        System.out.println(answer);
    }

    public static String removeDigit(String number, char digit){
        ArrayList<String> digits = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String stringWithoutDigit = number.substring(0, i) + number.substring(i + 1);
                digits.add(stringWithoutDigit);
            }
        }
        Collections.sort(digits);
        return digits.get(digits.size() - 1);

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

    interface TimeProvider {
        long getMillis();
    }


    public class CachingDataStructure {

        private Map<String, TreeMap<Integer, String>> cache;
        private int maxSize;
        private TimeProvider timeProvider;

        CachingDataStructure(TimeProvider timeProvider, int maxSize) {
            this.timeProvider = timeProvider;
            this.maxSize = maxSize;
        }

        public void put(String key, String value, long timeToLeaveInMilliseconds) {
            cache.putIfAbsent(key, new TreeMap());
            cache.get(key).put((int) timeToLeaveInMilliseconds, value);
        }

        public Optional<String> get(String key) {
            TreeMap<Integer, String> treeMap = cache.getOrDefault(key, new TreeMap());
            Map.Entry<Integer, String> entry = treeMap.floorEntry((int)timeProvider.getMillis());
            String result;
            if(entry == null){
                result = "";
            }
            else {
                result = entry.getValue();
            }
            return Optional.ofNullable(entry.getValue());
        }

        public int size() {
            return maxSize;
        }

    }

}
