public class AUGUST292026{
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        // inference
        // saamne se kuch bhi ho lekin piche se  ending se same hi rahenge 
        boolean isSame = true;
        
        while (i >= 0 || j >= 0) {
            //if we skipped the '#' then we need to skip the backspace alphabet also
            int skipS = 0;
            while(i >= 0){
                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                } 
                else if(skipS>0){
                    skipS--;
                    i--;
                } 
                else{
                    break;
                }
            }

            // Find valid character index for t
            int skipT = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // Compare character matches
            if (i >= 0 && j >= 0) {
                char ch1 = s.charAt(i);
                char ch2 = t.charAt(j);
                if (ch1 != ch2) {
                    isSame = false;
                    return isSame;
                }
            } else if ((i >= 0) != (j >= 0)) {
                isSame = false;
                return isSame;
            }

            i--;
            j--;
        }

        return isSame;
    }
}
//time complexity: O(m+n)
//space complexity: O(1)