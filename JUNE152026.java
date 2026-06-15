public class JUNE152026 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int k = 0 ;//rotation at where
        if(nums.length == 0){
            return -1;
        }
        
        while (left < right) {
            mid = left + (right - left) / 2;
            // If mid element is greater than right element, pivot is to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 'left' is now the index of the smallest element, which is our pivot 'k'
        k = left;
        //reset left and right
        left = 0;
        right = nums.length - 1;

        while(left <= right){
            // 1. Calculate the standard virtual midpoint first
            int virtualMid = left + (right - left)/2;
            
            // 2. Map that virtual midpoint to the actual circular array index
            int circularMid = (virtualMid + k) % nums.length;
            
            if(nums[circularMid] == target){
                return circularMid;
            }
            else if(nums[circularMid] > target){
                right = virtualMid - 1;
            }
            else{
                left = virtualMid + 1;
            }
        }
        return -1;
    }
}

//time complexity: O(log n)
//space complexity: O(1)