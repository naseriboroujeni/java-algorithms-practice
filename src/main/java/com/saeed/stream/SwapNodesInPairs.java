package com.saeed.stream;

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode previous = null;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            if (previous == null) {
                head = second;
            } else {
                previous.next = second;
            }
            previous = first;
            first = first.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode firstSample = new ListNode(1);
        firstSample.next = new ListNode(2);
        firstSample.next.next = new ListNode(3);
        firstSample.next.next.next = new ListNode(4);
        System.out.println(swapPairs(firstSample));

        ListNode secondSample = new ListNode(5);
        System.out.println(swapPairs(secondSample));
    }
}
