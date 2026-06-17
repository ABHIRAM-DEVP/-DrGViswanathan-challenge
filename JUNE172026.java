import java.util.HashMap;
import java.util.Map;

public class JUNE172026 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            ransomMap.put(ch, ransomMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(magazineMap.getOrDefault(ch, 0) < ransomMap.get(ch)){
                return false;
            }
        }
        return true;
    }
}

//time complexity: O(n + m) where n is the length of ransomNote and m is the length of magazine
//space complexity: O(n + m) for the two hash maps



//optimal

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCounts = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            charCounts[magazine.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            charCounts[index]--;
            
            if (charCounts[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
//time complexity: O(n + m) where n is the length of ransomNote and m is the length of magazine
//space complexity: O(1) since the size of the array is constant (26 letters