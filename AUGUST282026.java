public class Solution {
    public int AUGUST282026(int[] nums, int k) {
        //subarray : use sliding window because backtrack will cause subsets with non contiguous elements

        //inference : if i=0 to j=2  is valid subset => [0], [0,1], [0,1,2] is  also valid => j-i+1
        //pop out from left while produt >=k with i++ and then again calc subset j-i+1
        int product = 1;
        int count = 0;
        int i=0;
        if(k<=1) return 0;
        for(int j=0; j<nums.length; j++){
            product*= nums[j];
            
            while(product>=k){
                product /= nums[i];
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
}

//time complexity: O(n)
//space complexity: O(1)