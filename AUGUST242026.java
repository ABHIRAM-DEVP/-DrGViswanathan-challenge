import java.util.*;
public class AUGUST242026{
    static final Map<Character, String>PHONE_MAP = new HashMap<>();
    static{
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }    
        
    public void letterCombination(String digits, int index, StringBuilder temp, List<String>result){

        //base case
        if(temp.length()==digits.length()){
            result.add(temp.toString());
            return;
        }
        String letter = PHONE_MAP.get(digits.charAt(index));

        for(int i=0; i<letter.length(); i++){
            char ch = letter.charAt(i);
            temp.append(ch);
            letterCombination(digits, index+1, temp, result);
            temp.deleteCharAt(temp.length()-1); //when removed => here index+1 not done hence 2 continues and not 3 here
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String>result = new ArrayList<>();
        if(digits == null || digits.length()==0){
            return result;
        }
        letterCombination(digits, 0, new StringBuilder() , result);
        return result;
        
    }
}

//time complexity: O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters and M is the number of digits in the input 
//space complexity: O(N) for the recursion stack, where N is the length of the input digits. 