/**
 * Created by wenhang on 2/9/14.
 */

/**
 * http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1 ) {
            return 0;
        }

        int maxProfit = 0;
        boolean holding = false;
        int buyPrice = 0;

        int i = 0;
        for (i = 0; i < prices.length - 1; i++) {
            if (holding) {
                if (prices[i+1] < prices[i]) {
                    maxProfit += prices[i] - buyPrice;
                    holding = false;
                }
            } else {
                if (prices[i+1] > prices[i]) {
                    buyPrice = prices[i];
                    holding = true;
                }
            }
        }

        //Last day
        if (holding) {
            maxProfit += prices[prices.length - 1] - buyPrice;
            holding = false;
        }

        return maxProfit;
    }
}