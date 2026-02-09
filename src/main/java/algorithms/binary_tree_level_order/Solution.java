package algorithms.binary_tree_level_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
     * Traverse binary tree level by level using BFS (Queue).
     * Time Complexity: O(n)
     * Space Complexity: O(w) - max width of the tree.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case
        if (root == null) {
            return result;
        }

        // Use a Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with root

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in current level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add children to queue for the NEXT level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the current level list to the final result
            result.add(currentLevel);
        }

        return result;
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

        List<List<Integer>> result = solver.levelOrder(root);
        
        // Print Result
        System.out.println("Level Order: " + result);

        // Manual Check
        // Expected: [[3], [9, 20], [15, 7]]
        if (result.size() == 3 && result.get(1).contains(20)) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}