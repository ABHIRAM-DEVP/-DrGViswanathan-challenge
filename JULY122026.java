import java.util.Arrays;
import java.util.Comparator;
public class JULY122026 {
    private static class Job {
        int start, end, profit;
        Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }   
        // Sort jobs by start time to process them chronologically
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.start));
        // dp[i] stores the max profit obtainable from jobs[i...n-1]
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return getMaxProfit(0, jobs, dp);
    }
    
    private int getMaxProfit(int index, Job[] jobs, int[] dp) {
        if (index >= jobs.length) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        // Option 1: Skip the current job
        int skip = getMaxProfit(index + 1, jobs, dp);
        
        // Option 2: Take the current job
        // Find the next non-overlapping job using binary search
        int nextJobIndex = findNextJob(index + 1, jobs[index].end, jobs);
        int take = jobs[index].profit + getMaxProfit(nextJobIndex, jobs, dp);
        
        // Store and return the optimal choice
        return dp[index] = Math.max(skip, take);
    }
    
    // Binary search to find the first job that starts >= targetEndTime
    private int findNextJob(int left, int targetEndTime, Job[] jobs) {
        int right = jobs.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].start >= targetEndTime) {
                right = mid; // Narrow search to the left half
            } else {
                left = mid + 1; // Narrow search to the right half
            }
        }
        return left;
    }
}

/* Time Complexity:

Sorting: O(N log N) where N is the number of jobs.



DP State Transitions: There are N states, and each state utilizes a Binary Search (findNextJob) which takes O(log N) time.



Total Time: O(N log N) — highly efficient and easily scales to large inputs.



Space Complexity: O(N) — required for the jobs object array storage and the auxiliary dp array used for caching computed states.

*/