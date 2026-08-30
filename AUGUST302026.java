import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AUGUST302026{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>result = new ArrayList<>();
        if(nums.length<4)return result;
        for(int i=0; i<nums.length-3; i++){
            //3sum
            //skip duplicate strategy:
            //with i as same if one number j changes for a target then k and l will also or atleast the answers will be unique

            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int k=j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        //skip duplicates
                        while(k<l && nums[k]==nums[k+1])k++; //inner loop duplicate handling
                        while(k<l && nums[l]==nums[l-1])l--;
                        //while loops stop at last copy of duplicate number
                        k++;
                        l--;
                    }
                    else if(sum>target){
                        l--;
                    }
                    else{
                        k++;
                    }
                    
                }
            }
        }
        return result;
    }
}
//time complexity: O(n^3) because 3 nested loops
//space complexity: O(1) if we don't consider the output list