public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minProfit = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minProfit){
                minProfit = prices[i];
            }else if(prices[i] - minProfit > profit){
                profit = prices[i] - minProfit;
            }
        }
        return profit;
    }
}
