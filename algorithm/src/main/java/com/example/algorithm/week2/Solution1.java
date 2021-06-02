package com.example.algorithm.week2;

public class Solution1 {

    //给你一个链表的头节点 head 和一个整数 val ，
    //请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return sentinel.next;
    }

    //给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    //
    //如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        p = head;
        int index = length % 2 == 0 ? length / 2 : length / 2 - 1;
        int i = 0;
        while (p != null) {
            if (i == index) break;
            p = p.next;
            i++;
        }
        return p;
    }
}
