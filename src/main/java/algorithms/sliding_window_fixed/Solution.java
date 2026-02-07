package algorithms.sliding_window_fixed;

import java.util.Arrays;

public class Solution {

    /**
     * Find the maximum sum of a subarray of size K using Sliding Window.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public long maxSum(int[] arr, int k) {
        // Edge case: If array length is smaller than k, it's invalid
        if (arr.length < k) {
            return -1;
        }

        // Step 1: Calculate the sum of the first window
        long currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }

        // Initialize maxSum with the first window's sum
        long maxSum = currentWindowSum;

        // Step 2: Slide the window from the k-th element to the end
        for (int i = k; i < arr.length; i++) {
            // Formula: NewSum = OldSum + (Element Entering) - (Element Leaving)
            currentWindowSum += arr[i] - arr[i - k];
            
            // Update maxSum if the new window is better
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        long result = solver.maxSum(arr, k);

        // Print Result
        System.out.println("Input: " + Arrays.toString(arr) + ", k=" + k);
        System.out.println("Max Sum: " + result);

        // Manual Check
        if (result == 9) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}