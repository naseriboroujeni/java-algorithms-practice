package com.saeed.stream;

public class LinkedListCycleStart {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{3, 2, 0, -4});
        head.next.next.next.next = head.next; // cycle starts at node with val = 2

        ListNode start = detectCycle(head);
        if (start != null) {
            System.out.println("Cycle starts at node with value: " + start.val);
        } else {
            System.out.println("No cycle.");
        }
    }
}
