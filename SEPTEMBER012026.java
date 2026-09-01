public  class SEPTEMBER012026{
    public void nextPermutation(int[] nums){
        int n = nums.length;
        int i = n - 2;

        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = n - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

//time complexity: O(n)
//space complexity: O(1)

//find the i where nums[i] < nums[i+1] from the right
//find the j where nums[j] > nums[i] from the right
//swap nums[i] and nums[j]
//reverse the subarray from i+1 to end