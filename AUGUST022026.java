import java.util.Arrays;

public class AUGUST022026{
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int max = amount + 1;
        int[][] dp = new int[n + 1][amount + 1];
        
        Arrays.fill(dp[0], max);
        dp[0][0] = 0;
        

        for (int i = 1; i <= n; i++){
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++){
                dp[i][j] = dp[i - 1][j];
                
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }
}

//Time Complexity: O(N * amount)
//Space Complexity: O(N * amount)
