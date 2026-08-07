public class AUGUST072026{
    public boolean isAlienSorted(String[] words, String order){
        int[] charMap = new int[26];
        for(int i=0; i< order.length(); i++){
            charMap[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < words.length - 1; i++){
            if(!compare(words[i], words[i + 1], charMap)){
                return false;
            }
        }

        return true;
    }

    private boolean compare(String s1, String s2, int[] charMap) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int j = 0; j < minLen; j++) {
            char c1 = s1.charAt(j);
            char c2 = s2.charAt(j);

            if (c1 != c2) {
                return charMap[c1 - 'a'] < charMap[c2 - 'a'];
            }
        }

        return len1 <= len2;
    }
}
//Time Complexity: O(N * M)
//Space Complexity: O(1)
