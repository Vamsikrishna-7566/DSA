/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 *
 * Approach: Brute force
 *
 * Check every valid pair of buying and selling days. For each selling day,
 * examine all earlier buying days and keep the greatest profit found.
 *
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStockBruteForce {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;

        // Choose each possible selling day.
        for (int sell = prices.length - 1; sell > 0; sell--) {

            // Check every earlier day as a possible buying day.
            for (int buy = sell - 1; buy >= 0; buy--) {
                int currentProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}
