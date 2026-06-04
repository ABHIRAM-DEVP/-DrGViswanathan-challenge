
import java.util.*;

public class 4-04JUNE2026 {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count occurrences of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Initialize buckets with empty lists to avoid null checks later
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Group numbers by their frequency
        for (int num : map.keySet()) {
            int count = map.get(num);
            buckets[count].add(num);
        }

        // Step 4: Collect top k elements starting from the end
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) return result; // Exit early once we have k elements
            }
        }

        return result;
    }
}

//time complexity: O(n) where n is the length of the input array nums
//space complexity: O(n) in the worst case