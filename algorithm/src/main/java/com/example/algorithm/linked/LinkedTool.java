package com.example.algorithm.linked;

public class LinkedTool {

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
