import java.util.HashMap;
import java.util.Map;

public class JUNE212026 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>frequency = new HashMap<>();
        //sliding window for subarray
        int low=0;
        int k=1;
        int maxLength = 0;
        for(int high=0; high<s.length();high++){
            char i = s.charAt(high);
            frequency.put(i, frequency.getOrDefault(i,0)+1); //get c  => count+1 .

            while(frequency.get(i)>k){
                char leftMost = s.charAt(low);
                frequency.put(leftMost, frequency.get(leftMost)-1);
                if(frequency.get(leftMost)==0){
                    frequency.remove(leftMost);
                }
                low++;
            }
            //else jab tak duplicate nhi hai, keep measurement for longest length
            maxLength = Math.max(maxLength, high-low+1);
        }
        return maxLength;
    }
}

//time complexity: O(n) where n is the length of string s
//space complexity: O(min(m,n)) where m is the size of character set and n