public class JUNE202026{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //in bucket put +1 for char in s
            //and put a -1 when char in t
            //thus count will be 0 when equal numbers of +1 and -1 for each char
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}
//time complexity: O(n) where n is the length of string s or t
//space complexity: O(1) since we are using a fixed size array of 26