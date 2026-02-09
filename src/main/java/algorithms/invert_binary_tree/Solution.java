package algorithms.invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

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
     * Invert a binary tree using Recursion (DFS).
     * Time Complexity: O(n)
     * Space Complexity: O(h) - Height of the tree.
     */
    public TreeNode invertTree(TreeNode root) {
        // Base case: If node is null, return null
        if (root == null) {
            return null;
        }

        // Recursive step 1: Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursive step 2: Call recursively on left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Helper to print tree (Level Order Traversal - BFS)
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct tree:
        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3 6   9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        System.out.print("Original Tree (Level Order): ");
        printLevelOrder(root);

        // Invert
        solver.invertTree(root);

        System.out.print("Inverted Tree (Level Order): ");
        printLevelOrder(root);
        
        // Manual Check
        // Expect: 4 7 2 9 6 3 1
        if (root.left.val == 7 && root.right.val == 2) {
             System.out.println("[PASS] Test Passed!");
        } else {
             System.out.println("[FAIL] Test Failed!");
        }
    }
}