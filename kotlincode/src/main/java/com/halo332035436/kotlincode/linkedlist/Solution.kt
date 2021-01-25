package com.halo332035436.kotlincode.linkedlist

class Solution {
    companion object {
        fun hasCycle(head: Node): Boolean {
            val set = mutableSetOf<Node>()
            var currentNode = head
            while (currentNode != null) {
                if (!set.add(currentNode)) {
                    return true
                }
                if (currentNode.next == null) {
                    break
                } else {
                    currentNode = currentNode.next!!
                }
            }
            return false
        }
    }
}