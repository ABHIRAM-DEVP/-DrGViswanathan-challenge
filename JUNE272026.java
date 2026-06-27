public class JUNE272026 {
    public int maxProfit(int[] prices) {
        int maxProfitSale = 0;

        for (int i = 1; i < prices.length; i++) {
            // If the price went up from yesterday, add the profit 
            if (prices[i] > prices[i - 1]) {
                maxProfitSale += prices[i] - prices[i - 1];
            }
        }

        return maxProfitSale;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        //to buy and sell continuously 
        //buy it
        //but sell the moment we find it of more price than we brought
        
        int maxProfitSale = 0;
        int minBuy = prices[0];
        int profit = 0;

        for(int i=0; i<prices.length; i++){

            int currentPrice = prices[i];
            if(minBuy < currentPrice){
                if(i+1 <prices.length && prices[i+1]> prices[i]){
                    continue;
                }
                profit = currentPrice - minBuy;
                maxProfitSale += profit;
                minBuy = Integer.MAX_VALUE;
                continue;
            }
            
            minBuy = Math.min(minBuy, currentPrice);
        }
        return maxProfitSale;
    }
}

//time complexity: O(n)
//space complexity: O(1)
