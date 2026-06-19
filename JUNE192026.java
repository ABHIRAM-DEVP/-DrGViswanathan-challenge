public class JUNE192026 {
    public boolean isSubsequence(String s, String t) {
        //to find subsequence
        //using two pointers
        //where i will iter in string t
        //and j will iter in string s
        int j=0;
        if(t.length()==0 && s.length() !=0){
            return false;
        }
        if(s.length() == 0 ){
            return true;
        }

        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
            if(j == s.length()){
            return true;
        }
            
        }
        
        
        return false;
    }
}


//time complexity: O(n) where n is the length of string t
//space complexity: O(1) since we are not using any extra space for finding subsequence, we are just using two pointers.