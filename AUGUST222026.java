import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Arrays;


public class AUGUST222026{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] h = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i=1; i<= N; i++){
            for(int j=1; j<= K && i + j <= N; j++){
                int nextStone = i + j;
                int cost = dp[i] + Math.abs(h[i]-h[nextStone]);
                if(cost < dp[nextStone]){
                    dp[nextStone] = cost;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
//Time Complexity: O(N * K)
// Space Complexity: O(N)