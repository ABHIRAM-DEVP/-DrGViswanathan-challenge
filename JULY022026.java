import java.util.HashMap;
import java.util.Map;
public class JULY022026 {
    public String minWindow(String s, String t) {
        Map<Character,Integer>tReq = new HashMap<>();
        Map<Character,Integer>sHave = new HashMap<>();

        int m = s.length();
        int n = t.length();

        for(int i = 0; i<n; i++){
            char a = t.charAt(i);
            tReq.put(a, tReq.getOrDefault(a,0)+1);
        }

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int required = tReq.size(); //a,a,b,b,c imply tReq =3
        int haveCount = 0;
        int start = 0;

        for(int high = 0; high<m; high++){
            char i = s.charAt(high);
            
            if (tReq.containsKey(i)){
                sHave.put(i, sHave.getOrDefault(i, 0) + 1);

                if (sHave.get(i).equals(tReq.get(i))) {
                    haveCount++;
                }
            }
//this is the attempt to minimize when we reach the basic required size with all necessary elements
            while(haveCount == required){
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                }
                char leftMost = s.charAt(low);
                if (tReq.containsKey(leftMost)) {
                    sHave.put(leftMost, sHave.get(leftMost) - 1);
                    // If we drop below what t requires, break the valid condition
                    if (sHave.get(leftMost) < tReq.get(leftMost)) { //individual element verify
                        haveCount--;
                    }
                }
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}

//time complexity: O(m + n) where m is the length of string s and n is the length of string t
//space complexity: O(m + n) for the two hash maps used to store character counts

