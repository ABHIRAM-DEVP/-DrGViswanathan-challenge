public class JUNE052026{
    public int maxProfit(int[] prices) {

        //maximum profit = max sell price - min purchase price
        int maxProfit = Integer.MIN_VALUE;
        int minStockBuyPrice  = prices[0];

        //edge case
        if (prices == null || prices.length < 2) {
            return 0; // Can't buy and sell if there's less than 2 days of data
        }

        for(int i = 1; i<prices.length; i++){
            int currentSellingPrice = prices[i] - minStockBuyPrice;
            //then update minStock and maxProfit
            minStockBuyPrice = Math.min(minStockBuyPrice, prices[i]);

            maxProfit = Math.max(maxProfit, currentSellingPrice);

        }
        if(maxProfit<0){
            return 0;
        }
        return maxProfit;
         
    }
}





//time complexity: O(n) where n is the length of the input array nums
//space complexity: O(n) in the worst case