package algorithms.reverse_linked_list;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    /**
     * Reverse a singly linked list iteratively.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save next node
            curr.next = prev;              // 2. Reverse the link
            prev = curr;                   // 3. Move prev step forward
            curr = nextTemp;               // 4. Move curr step forward
        }

        return prev; // New head is prev
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reverse it
        ListNode newHead = solver.reverseList(head);

        System.out.println("Reversed List:");
        printList(newHead);

        // Manual Check
        if (newHead.val == 5 && newHead.next.val == 4) {
            System.out.println("[PASS] Test Passed!");
        } else {
            System.out.println("[FAIL] Test Failed!");
        }
    }
}