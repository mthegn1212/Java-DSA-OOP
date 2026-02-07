package algorithms.longest_substring_unique;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Find the length of the longest substring without repeating characters.
     * Time Complexity: O(n) - Linear time.
     * Space Complexity: O(min(m, n)) - Set stores unique characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        // Use a Set to keep track of characters in the current window
        Set<Character> window = new HashSet<>();

        while (right < s.length()) {
            char charAtRight = s.charAt(right);

            if (!window.contains(charAtRight)) {
                // Case 1: New character is unique
                window.add(charAtRight);       // Add to window
                
                // Update max length (current window size is right - left + 1)
                // But since right hasn't incremented yet in calculation logic below, careful with indices
                // Let's keep it simple: Add first, then calculate size
                
                maxLength = Math.max(maxLength, window.size());
                right++; // Move right pointer forward
            } else {
                // Case 2: Duplicate found!
                // We must shrink the window from the left until the duplicate is removed
                char charAtLeft = s.charAt(left);
                window.remove(charAtLeft);
                left++; // Move left pointer forward
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        String s1 = "abcabcbb";
        int result1 = solver.lengthOfLongestSubstring(s1);
        System.out.println("Input: " + s1 + " -> Output: " + result1);
        
        // Test Case 2
        String s2 = "bbbbb";
        int result2 = solver.lengthOfLongestSubstring(s2);
        System.out.println("Input: " + s2 + " -> Output: " + result2);

        // Test Case 3
        String s3 = "pwwkew";
        int result3 = solver.lengthOfLongestSubstring(s3);
        System.out.println("Input: " + s3 + " -> Output: " + result3);

        // Manual Check
        if (result1 == 3 && result2 == 1 && result3 == 3) {
            System.out.println("[PASS] All tests passed!");
        } else {
            System.out.println("[FAIL] Something is wrong.");
        }
    }
}