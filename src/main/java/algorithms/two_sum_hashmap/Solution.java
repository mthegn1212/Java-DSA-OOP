package algorithms.two_sum_hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Find indices of two numbers that add up to target using HashMap.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        // Map to store value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Found the pair! Return their indices.
                return new int[] { map.get(complement), i };
            }

            // If not found, store the current number and its index
            map.put(current, i);
        }

        // Should not happen as per problem description
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solver.twoSum(nums1, target1);
        System.out.println("Input: [2, 7, 11, 15], Target: 9 -> Output: " + Arrays.toString(result1));

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solver.twoSum(nums2, target2);
        System.out.println("Input: [3, 2, 4], Target: 6 -> Output: " + Arrays.toString(result2));

        // Manual Check
        if (result1[0] == 0 && result1[1] == 1 && result2[0] == 1 && result2[1] == 2) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}