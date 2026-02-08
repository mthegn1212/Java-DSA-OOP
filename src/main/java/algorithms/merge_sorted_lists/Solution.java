package algorithms.merge_sorted_lists;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    /**
     * Merge two sorted linked lists using Iterative method with Dummy Node.
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node acting as the anchor
        ListNode dummy = new ListNode(-1);
        
        // 2. Current pointer starts at dummy
        ListNode current = dummy;

        // 3. Loop while both lists have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Link to list1 node
                list1 = list1.next;   // Move list1 forward
            } else {
                current.next = list2; // Link to list2 node
                list2 = list2.next;   // Move list2 forward
            }
            current = current.next;   // Move current forward
        }

        // 4. Attach the remaining part (if any)
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // 5. Return the actual head (skip the dummy)
        return dummy.next;
    }

    // Helper to print list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Create list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Create list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.print("List 1: "); printList(list1);
        System.out.print("List 2: "); printList(list2);

        // Merge
        ListNode mergedHead = solver.mergeTwoLists(list1, list2);

        System.out.print("Merged: "); printList(mergedHead);

        // Simple Manual Test
        if (mergedHead.val == 1 && mergedHead.next.val == 1 && mergedHead.next.next.val == 2) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}