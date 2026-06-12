import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JUNE122026 {
    public List<List<Integer>> threeSum(int[] nums) {
        //3sum problem : two pointer approach at each kth element

        //such that sum = 0

        //sorting it and then pushing pairs into arraylist of list

        Arrays.sort(nums);

        List<List<Integer>>result = new ArrayList<>();

        for(int k=0; k<nums.length; k++){
            //since array is sorted
            //adding a duplicate number check as per give constraint

            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }

            int complement = (-1)*nums[k]; //negative of complement matches sum of other two
            int i = k+1;
            int j= nums.length -1;
            while(i<j){
                int sum = nums[i]+nums[j];
                if(sum==complement){
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++; 
                    j--;
// update i and j, because when even a single adjacent number changes the sum also changes 
                    while(i<j && nums[i]==nums[i-1]){
                        i++;
                    }

                    while(j>=0 && nums[j]==nums[j+1]){
                        j--;
                    }
                }
                else if(sum>complement){
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return result;
    }
}
