package algorithms.max_depth_binary_tree;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    /**
     * Find maximum depth using Recursion (DFS).
     * Time Complexity: O(n)
     * Space Complexity: O(h) - Height of the tree (recursion stack).
     */
    public int maxDepth(TreeNode root) {
        // Base case: If node is null, depth is 0
        if (root == null) {
            return 0;
        }

        // Recursive step: Calculate depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Current depth = 1 (current node) + max of children's depth
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct tree:
        //      3
        //    /   \
        //   9    20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        int depth = solver.maxDepth(root);
        System.out.println("Max Depth: " + depth);

        // Manual Check
        if (depth == 3) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}