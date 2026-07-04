public class JULY042026{
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (i > maxReachable) {
                return false;
            }               
            maxReachable = Math.max(maxReachable, i + nums[nums.length - 1 - (nums.length - 1 - i)]); 

            maxReachable = Math.max(maxReachable, i + nums[i]);

            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}

//time complexity: O(n)
//space complexity:O(1)