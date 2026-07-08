public class JULY082026 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
    
        boolean[] dp = new boolean[n+1];
        dp[0]=true; 

        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        
        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxLen; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid segmentation for s.substring(0, i)
                }
            }
        }
        
        return dp[n];
    }
}

//time complexity : O(n*m)
//space complexity : O(n+k)
