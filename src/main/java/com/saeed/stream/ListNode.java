package com.saeed.stream;

public class ListNode {
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
