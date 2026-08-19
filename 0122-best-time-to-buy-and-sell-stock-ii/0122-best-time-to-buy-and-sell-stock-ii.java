class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int notBuy = 0 ;

        for(int i = 1 ; i < prices.length ; i++){
            int prevBuy = buy ;
            int prevNotBuy = notBuy ;

            buy = Math.max(prevBuy , prevNotBuy - prices[i]);
            notBuy = Math.max(prevNotBuy , prevBuy + prices[i] );
        }

        return notBuy ;
    }
}