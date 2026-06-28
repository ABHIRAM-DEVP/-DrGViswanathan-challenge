public class JUNE282026 {
    public int findDuplicate(int[] nums) {
        // by slow and fast pointers

        //since n size n-1 unique elements

        //by cycle detection

        // i -> a[i]

        int slow =0;
        int fast =0;
        while(true){
            //move slow and fast pointers ahead
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            //cycle detection
            if(slow == fast){
                break;
            }
        }
        slow = 0;
        while(slow != fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;

    }
}

//time complexity: O(n)
//space complexity: O(1)