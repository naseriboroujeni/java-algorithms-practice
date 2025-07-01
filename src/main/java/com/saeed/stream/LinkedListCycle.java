package com.saeed.stream;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test 1: No cycle
        ListNode noCycleHead = ListNode.createLinkedList(new int[]{3, 2, 0, -4});
        System.out.println("Has cycle (should be false)? " + hasCycle(noCycleHead));

        // Test 2: Cycle at position 1 (2nd node)
        ListNode cycleHead = ListNode.createLinkedList(new int[]{3, 2, 0, -4});
        cycleHead.next.next.next.next = cycleHead.next; // -4 -> 2
        System.out.println("Has cycle (should be true)? " + hasCycle(cycleHead));

        // Test 3: Single node, no cycle
        ListNode single = new ListNode(1);
        System.out.println("Has cycle (should be false)? " + hasCycle(single));

        // Test 4: Single node pointing to itself
        ListNode selfCycle = new ListNode(1);
        selfCycle.next = selfCycle;
        System.out.println("Has cycle (should be true)? " + hasCycle(selfCycle));
    }
}
