package algorithms.best_time_buy_sell_stock;

public class Solution {

    /**
     * Calculate maximum profit from a single buy and sell.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Start with a very high price
        int maxProfit = 0;                // Start with 0 profit

        for (int price : prices) {
            if (price < minPrice) {
                // Found a new lowest price to buy!
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Found a better selling opportunity!
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Standard case
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solver.maxProfit(prices1);
        System.out.println("Input: [7, 1, 5, 3, 6, 4] -> Output: " + result1);

        // Test Case 2: Prices always go down (No profit)
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solver.maxProfit(prices2);
        System.out.println("Input: [7, 6, 4, 3, 1] -> Output: " + result2);

        // Manual Check
        if (result1 == 5 && result2 == 0) {
            System.out.println("[PASS] All tests passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}