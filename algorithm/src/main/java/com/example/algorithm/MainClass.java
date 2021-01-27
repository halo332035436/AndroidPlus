package com.example.algorithm;

import com.example.algorithm.exercise.ExerciseTool;
import com.example.algorithm.linked.LinkedTool;
import com.example.algorithm.linked.ListNode;

public class MainClass {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode2;

//        boolean hasCycle = LinkedTool.hasCycleBySet(listNode1);
//
//        System.out.println(hasCycle);

//        LinkedTool.reverseList(listNode1);

        ListNode listNode = LinkedTool.removeElements(listNode1, 2);
        System.out.println(listNode);


        ExerciseTool.getLight();
    }

}