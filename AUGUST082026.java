public class AUGUST082026{
    public int minDistance(String word1, String word2){

        if(word1.length() < word2.length()){
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            curr[0] = i; 

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {

                    int insertOp = curr[j - 1];   // Insertion
                    int deleteOp = prev[j];     // Deletion
                    int replaceOp = prev[j - 1];  // Replacement
                    
                    curr[j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}


//Time Complexity:  O(M * N)
//Space Complexity: O(min(M, N))