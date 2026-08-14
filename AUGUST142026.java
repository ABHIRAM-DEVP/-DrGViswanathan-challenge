import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class AUGUST142026{
    public int leastInterval(char[] tasks, int n){
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                currentFreq--; 
                if (currentFreq > 0) {
                    cooldownQueue.offer(new int[] { currentFreq, time + n });
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time){
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }
}

//Time Complexity: O(N)
//Space Complexity: O(1)