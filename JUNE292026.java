import java.util.HashMap;
import java.util.Map;

public class JUNE292026 {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefix_sum -> frequency)
        Map<Integer, Integer> prefixSums = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once
        prefixSums.put(0, 1);
        
        int currSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currSum += num;
            
            // Check if (currSum - k) exists in our history
            if (prefixSums.containsKey(currSum - k)) {
                count += prefixSums.get(currSum - k);
            }
            
            // Record the current prefix sum in the map
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}
//time complexity: O(n)
//space complexity: O(n)