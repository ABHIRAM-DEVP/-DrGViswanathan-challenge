public class JUNE112026 {
    public int[] twoSum(int[] numbers, int target) {
        //2sum with two pointer approach 
        //since the array is sorted: no hashmap needed 
        int i = 0;
        int j = numbers.length - 1;
        while(i<=j){
            int sum = numbers[i]+numbers[j];

            if(sum==target){
                return new int[]{i+1, j+1};
            }
            else if(sum>target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}

//time complexity: O(n)
//space complexity: O(1)
