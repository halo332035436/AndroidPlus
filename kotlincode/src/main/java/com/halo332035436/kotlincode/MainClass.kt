package com.halo332035436.kotlincode

import com.halo332035436.kotlincode.linkedlist.Node
import com.halo332035436.kotlincode.linkedlist.Solution

fun main() {

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node3

    val hasCycle = Solution.hasCycle(node1)

    println(hasCycle)

}