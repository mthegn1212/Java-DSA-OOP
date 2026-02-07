package algorithms.binary_search;

import java.util.Arrays;

public class Solution {

    /**
     * Find target index in sorted array using Binary Search.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Calculate mid index avoiding Integer Overflow
            // Normal formula: mid = (left + right) / 2 -> Can overflow if left + right > Integer.MAX_VALUE
            // Safe formula: mid = left + distance / 2
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found it!
            } 
            else if (nums[mid] < target) {
                // Target is larger -> Ignore left half
                left = mid + 1;
            } 
            else {
                // Target is smaller -> Ignore right half
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = solver.search(nums, target);

        // Print Result
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Output Index: " + result);

        // Manual Check
        if (result == 4) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}