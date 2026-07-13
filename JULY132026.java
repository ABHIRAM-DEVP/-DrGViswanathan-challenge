public class JULY132026{
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i =0; i<n; i++) {
            arr[i+1] = nums[i];
        }


        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len + 1;
                for (int k = i + 1; k < j; k++) {
                    int coins = arr[i] * arr[k] * arr[j];
                    int total = dp[i][k] + dp[k][j] + coins;
                    dp[i][j] = Math.max(dp[i][j], total);
                }
            }
        }
        return dp[0][n + 1];
    }
}

//time complexity: O(n^3) due to three nested loops iterating over the length of the array.
//space complexity: O(n^2) for the dp array used to store intermediate results.