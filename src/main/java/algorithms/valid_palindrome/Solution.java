package algorithms.valid_palindrome;

public class Solution {

    /**
     * Check if string is a valid palindrome using Two Pointers.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);

            // 1. Move left pointer if not alphanumeric
            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
            } 
            // 2. Move right pointer if not alphanumeric
            else if (!Character.isLetterOrDigit(charRight)) {
                right--;
            } 
            // 3. Both are valid characters -> Compare them
            else {
                if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                    return false; // Mismatch found
                }
                // Continue moving inward
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Complex Palindrome
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + s1 + "\" -> " + solver.isPalindrome(s1));

        // Test Case 2: Not a Palindrome
        String s2 = "race a car";
        System.out.println("Input: \"" + s2 + "\" -> " + solver.isPalindrome(s2));
        
        // Test Case 3: Empty string (Valid)
        String s3 = " ";
        System.out.println("Input: \"" + s3 + "\" -> " + solver.isPalindrome(s3));

        // Manual Check
        if (solver.isPalindrome(s1) && !solver.isPalindrome(s2)) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}