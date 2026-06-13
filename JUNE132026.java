public class JUNE132026 {
    public int search(int[] nums, int target) {
        //given array is sorted
        //to search the target , we can use binary search 
        //with low , mid and high as 3 points
        int low = 0;
        int high = nums.length-1;
        //if sum of same indices/2 return same index i.e = number [index]
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}

//time complexity: O(log n)
//space complexity: O(1)
