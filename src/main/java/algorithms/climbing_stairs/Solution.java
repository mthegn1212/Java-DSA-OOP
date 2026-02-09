package algorithms.climbing_stairs;

public class Solution {

    /**
     * Calculate distinct ways to climb stairs using Dynamic Programming.
     * This is essentially the Fibonacci sequence.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        int twoStepsBefore = 1; // Ways to reach step (i-2)
        int oneStepBefore = 2;  // Ways to reach step (i-1)
        int currentWays = 0;

        // Loop from step 3 to n
        for (int i = 3; i <= n; i++) {
            currentWays = oneStepBefore + twoStepsBefore;
            
            // Shift variables for next iteration
            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentWays;
        }

        return oneStepBefore;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int n1 = 2;
        System.out.println("Stairs: " + n1 + " -> Ways: " + solver.climbStairs(n1));

        // Test Case 2
        int n2 = 3;
        System.out.println("Stairs: " + n2 + " -> Ways: " + solver.climbStairs(n2));

        // Test Case 3
        int n3 = 5;
        // Expected: 1+1+1+1+1, 1+1+1+2 (x4 combinations), 1+2+2 (x3 combinations) -> Total 8
        System.out.println("Stairs: " + n3 + " -> Ways: " + solver.climbStairs(n3));

        // Manual Check (Fibonacci sequence: 1, 2, 3, 5, 8...)
        if (solver.climbStairs(5) == 8) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}