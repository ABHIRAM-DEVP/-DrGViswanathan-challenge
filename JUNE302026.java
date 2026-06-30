import java.util.ArrayList;
import java.util.List;

public class JUNE302026 {
    public List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }

        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        for (char c : p.toCharArray()) {
            pCounts[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            sCounts[s.charAt(right) - 'a']++;

            //when window exceed
            if (right - left + 1 > p.length()) {
                sCounts[s.charAt(left) - 'a']--;
                left++;
            }
            //always checking
            if (matches(pCounts, sCounts)) {
                result.add(left);
            }
        }

        return result;
    }

    private boolean matches(int[] pCounts, int[] sCounts) {
        for (int i = 0; i < 26; i++) {
            if (pCounts[i] != sCounts[i]) {
                return false;
            }
        }
        return true;
    }
}

//time complexity: O(n) where n is the length of string s
//space complexity: O(1) since the size of the count arrays is fixed at 26