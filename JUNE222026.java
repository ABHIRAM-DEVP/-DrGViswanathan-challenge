public class JUNE222026 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // Represents max money if we stopped 2 houses ago
        int prev1 = 0; // Represents max money if we stopped 1 house ago

        for (int num : nums) {
            // At each house, decide to rob it or skip it
            int currentMax = Math.max(prev1, prev2 + num);
            
            // Shift our variables forward for the next iteration
            prev2 = prev1;
            prev1 = currentMax;
        }
//Max Money at House i = Max( Max Money at House i-1 , Max Money at House i-2 + Current House Money )
        return prev1;
    }
}

//time complexity: O(n) where n is the length of the nums array
//space complexity: O(1) since we are using only a constant amount of space