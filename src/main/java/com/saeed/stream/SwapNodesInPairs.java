package com.saeed.stream;

public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(val);
            if (next != null) {
                result.append(", ");
                result.append(next);
            }
            return result.toString();
        }
    }

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
