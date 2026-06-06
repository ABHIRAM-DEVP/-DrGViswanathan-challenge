//06 june 2026

import java.util.*;

public class JUNE062026 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        List<int[]>mergedArray = new ArrayList<>();
        //overlap condition when y1 > x2 : set max of x2 and y2 
        //if not overlap , then merge the interval directly into array

        int[] currentInterval = intervals[0];
        mergedArray.add(currentInterval);
        
        for(int[] interval : intervals){
            int x1 = currentInterval[0];
            int x2 = currentInterval[1];
            int y1 = interval[0];
            int y2 = interval[1];

            if(x2 >= y1){
                currentInterval[1] = Math.max(x2, y2);
            }
            else{ //y1>x2
                currentInterval = interval;
                mergedArray.add(currentInterval);
            }
        }
        return mergedArray.toArray(new int[mergedArray.size()][]);

    }
}

//time complexity: O(nlogn)
//space complexity: O(n)
