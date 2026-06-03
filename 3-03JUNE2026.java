import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>map = new HashMap<>();

        for(String word : strs){
            char ArrayOfChar[] = new char[word.length()];
            for(int i=0; i<word.length(); i++){
                ArrayOfChar[i] = word.charAt(i);
            }
            Arrays.sort(ArrayOfChar);

            String sortedWord = new String(ArrayOfChar);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word); //key: value (word:list)
        }
        return new ArrayList<>(map.values());
    }
}

//time complexity: O(n*klogk) where n is the number of strings and k is the maximum length of a string
//space complexity: O(n*k) for the hashmap and the output list