package algorithms.two_sum_sorted;

import java.util.Arrays;

public class Solution {

    /**
     * Find indices of two numbers that add up to the target using Two Pointers technique.
     * Time Complexity: O(n) - Left and Right pointers move towards the center.
     * Space Complexity: O(1) - No extra memory used.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Found the target! Return the indices
                return new int[]{left, right}; 
            } 
            else if (currentSum > target) {
                // Sum is too large -> Need a smaller number -> Move right pointer to the left
                right--;
            } 
            else {
                // Sum is too small -> Need a larger number -> Move left pointer to the right
                left++;
            }
        }

        // Return [-1, -1] if no solution is found (though the problem guarantees a solution)
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test case
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = solver.twoSum(numbers, target);
        
        // Print results
        System.out.println("Input: " + Arrays.toString(numbers) + ", Target: " + target);
        System.out.println("Output Index: " + Arrays.toString(result));
        
        // Manual Test Check
        if (result[0] == 0 && result[1] == 1) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}