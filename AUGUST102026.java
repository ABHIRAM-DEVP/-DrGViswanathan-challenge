import java.util.PriorityQueue;
class AUGUST102026{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

//Time Complexity: O(N log k)
//Space Complexity: O(k)