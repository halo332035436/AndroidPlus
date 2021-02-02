package com.example.algorithm;

import com.example.algorithm.array.ArraySolution;
import com.example.algorithm.exercise.ExerciseTool;
import com.example.algorithm.linked.LinkedTool;
import com.example.algorithm.linked.ListNode;
import com.example.algorithm.sort.SortSolution;

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

//        ListNode listNode = LinkedTool.removeElements(listNode1, 2);
//        System.out.println(listNode);


//        ExerciseTool.getLight();

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {1, 1, 2};

//        ArraySolution.removeDuplicates(nums);

        int[] array = {4, 5, 6, 3, 2, 1};
//        SortSolution.bubbleSort(array, 6);
//        SortSolution.selectionSort(array, 6);
        SortSolution.mergeSort(array, 6);
    }

}