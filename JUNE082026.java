public class JUNE082026 {
    public int maxSubArray(int[] nums) {
        //using kadane's algorithm
        //for subarray with largest sum

        //choosing either bestEndingSum or  maxSum
        //where bestEndingSum as maxSum at each iteration level
        //and check with maxSum as global max Subarray

        int bestEndingSum = nums[0]; // compare at every level iteration
        int maxSum = nums[0]; //compare at global level

        for(int i=1; i<nums.length; i++){
            bestEndingSum += nums[i];
            bestEndingSum = Math.max(nums[i], bestEndingSum);
            maxSum = Math.max(bestEndingSum, maxSum);
        }
        return maxSum;
    }
}

//time complexity: O(n)
//space complexity: O(1)