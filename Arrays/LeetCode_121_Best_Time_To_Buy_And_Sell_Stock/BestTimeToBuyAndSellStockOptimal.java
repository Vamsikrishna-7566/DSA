/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 *
 * Approach: One pass
 *
 * Keep track of the lowest stock price seen so far. For each following day,
 * calculate the profit from selling at the current price and update the
 * maximum profit when the current transaction is better.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStockOptimal {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Profit from selling today after buying at the lowest prior price.
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);

            // Update the lowest buying price for future selling days.
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
