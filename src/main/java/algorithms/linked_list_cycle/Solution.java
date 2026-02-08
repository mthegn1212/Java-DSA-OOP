package algorithms.linked_list_cycle;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    /**
     * Detect cycle in a linked list using Floyd's Tortoise and Hare algorithm.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        // Edge case: Empty list or single node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;       // Tortoise
        ListNode fast = head;       // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move 1 step
            fast = fast.next.next;  // Move 2 steps

            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, there is no cycle
        return false;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Create a list with cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Create cycle here

        boolean hasCycle = solver.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle);

        // Test case no cycle: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Has Cycle (No cycle): " + solver.hasCycle(head2));

        // Manual Check
        if (hasCycle && !solver.hasCycle(head2)) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}