package com.saeed.stream;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode previous = head;
        ListNode toRemove = head;
        for (int i = 0; i < size - n; i++) {
            previous = toRemove;
            toRemove = toRemove.next;
        }
        if (toRemove == head) {
            return head.next;
        }
        previous.next = toRemove.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode firstSample = new ListNode(1);
        firstSample.next = new ListNode(2);
        firstSample.next.next = new ListNode(3);
        firstSample.next.next.next = new ListNode(4);
        firstSample.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(firstSample, 2));
    }
}
