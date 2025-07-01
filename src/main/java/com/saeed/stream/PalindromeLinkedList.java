package com.saeed.stream;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode reversedHead = reverseLinkedList(slow);

        while (reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }
            reversedHead = reversedHead.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = previous;
            previous = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        // Example 1: Palindrome (1 -> 2 -> 2 -> 1)
        ListNode head1 = ListNode.createLinkedList(new int[]{1, 2, 2, 1});
        System.out.println("Is Palindrome? " + isPalindrome(head1)); // true

        // Example 2: Not a Palindrome (1 -> 2)
        ListNode head2 = ListNode.createLinkedList(new int[]{1, 2});
        System.out.println("Is Palindrome? " + isPalindrome(head2)); // false

        // Example 3: Single Node (7)
        ListNode head3 = ListNode.createLinkedList(new int[]{7});
        System.out.println("Is Palindrome? " + isPalindrome(head3)); // true

        // Example 4: Empty list
        ListNode head4 = null;
        System.out.println("Is Palindrome? " + isPalindrome(head4)); // true
    }
}
