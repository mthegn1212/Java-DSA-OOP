package algorithms.valid_parentheses;

import java.util.Stack;

public class Solution {

    /**
     * Check if the string contains valid parentheses using Stack.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        // Use a Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Case 1: If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Case 2: If it's a closing bracket
            else {
                // If stack is empty, it means we have a closing bracket without a match
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element to check matching
                char top = stack.pop();

                // Check if the pair matches
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Final Check: The stack must be empty (all opened brackets are closed)
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Cases
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "{[]}";
        String s4 = "]"; // Edge case: Start with closing bracket

        System.out.println("Input: " + s1 + " -> " + solver.isValid(s1));
        System.out.println("Input: " + s2 + " -> " + solver.isValid(s2));
        System.out.println("Input: " + s3 + " -> " + solver.isValid(s3));
        System.out.println("Input: " + s4 + " -> " + solver.isValid(s4));

        // Manual Check
        if (solver.isValid(s1) && !solver.isValid(s2) && solver.isValid(s3) && !solver.isValid(s4)) {
            System.out.println("[PASS] All tests passed!");
        } else {
            System.out.println("[FAIL] Something is wrong.");
        }
    }
}