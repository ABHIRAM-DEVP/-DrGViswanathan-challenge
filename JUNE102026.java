public class JUNE102026 {
    public int[] productExceptSelf(int[] nums) {

        int result[] = new int[nums.length];
        result[0] = 1;

        //pivot element concept
        //prefix sum like concept
        //leftOfPivot's product and rightOfPivot's product

        for(int i=1; i<nums.length; i++){
            //at any ith position
            //its left/prefix product can be expressed as 
            //product of (i-1)element * prefix product of(i-1)element(i.e result of [i-1]product)
            result[i] = result[i-1]*nums[i-1];
        }
        //above loop left to right

        //below loop right to left
        int suffix = 1;
        for(int i=nums.length-1; i>=0; i--){
            //at any ith position
            //its right/uffix product will be expressed as 
            //product of left prefix i.e from result array * suffix

            //updating from right
            result[i]*=suffix;
            //to update i-1 element with updated suffix
            suffix *= nums[i];
        }
        return result;
    }
}

//time complexity: O(n)
//space complexity: O(1) (as per Leetcode's constraint)excluding The output array does not count as extra space for space complexity analysis
