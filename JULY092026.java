import java.util.Deque;
import java.util.LinkedList;

public class JULY092026 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; 
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // 1. Remove indices out of current window bounds
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Maintain monotonic decreasing property
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add current element's index
            deque.offerLast(i);
            
            // 4. Record maximum once the window reaches size k
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}

//time complexity: O(n)
//space complexity: O(k)