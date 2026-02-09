package algorithms.valid_anagram;

public class Solution {

    /**
     * Check if t is an anagram of s using Frequency Counter array.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (Fixed size array of 26)
     */
    public boolean isAnagram(String s, String t) {
        // 1. Basic check: Lengths must be equal
        if (s.length() != t.length()) {
            return false;
        }

        // 2. Use integer array to count character frequencies
        // assuming input contains only lowercase English letters
        int[] count = new int[26];

        // 3. Count frequencies
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for s
            count[t.charAt(i) - 'a']--; // Decrement for t
        }

        // 4. Verify all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Valid anagram
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Input: " + s1 + ", " + t1 + " -> " + solver.isAnagram(s1, t1));

        // Test Case 2: Invalid anagram
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Input: " + s2 + ", " + t2 + " -> " + solver.isAnagram(s2, t2));

        // Manual Check
        if (solver.isAnagram(s1, t1) && !solver.isAnagram(s2, t2)) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}