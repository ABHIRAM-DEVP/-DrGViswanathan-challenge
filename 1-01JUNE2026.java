// DAY 1 

// 1st JUNE 2026

// TWO SUM PROBLEM ON LEETCODE

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //given array not sorted 
        //approach : using hashmap -> i index and compliment index
        Map<Integer, Integer>map = new HashMap<>();

        for(int i=0; i<nums.length ; i++){

            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}

//Time Complexity: O(n)

//Space Complexity: O(n)