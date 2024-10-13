package org.example.lesson2.reverse.solve2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Reverse method using ArrayList, all reverse objects are new.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        List<ListNode> listNodes = new ArrayList<>();

        ListNode listNodeNext = head;
        while (listNodeNext.next != null) {
            listNodes.add(new ListNode(listNodeNext.val));
            listNodeNext = listNodeNext.next;
        }
        listNodes.add(new ListNode(listNodeNext.val));

        Collections.reverse(listNodes);

        ListNode listNodeFirst = null;
        listNodeNext = null;

        for (ListNode listNodeNew : listNodes) {

            if (listNodeFirst == null) {
                listNodeFirst = listNodeNew;
                listNodeNext = listNodeNew;
                continue;
            }

            listNodeNext.next = listNodeNew;
            listNodeNext = listNodeNew;
        }

        return listNodeFirst;
    }

    public static void main(String[] args) {
        System.out.println("lesson 2 HW - 1 (solve 2)");

        System.out.println("---");

        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(3, listNode3);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNodeStart = new ListNode(5, listNode5);

        Solution solution = new Solution();

        System.out.println("original listNode");
        System.out.println(listNodeStart);

        System.out.println("---");

        ListNode newObjListNode = solution.reverseList(listNodeStart);
        System.out.println("reverse with ArrayList");
        System.out.println(newObjListNode);
        System.out.println("new obj: " + (newObjListNode != listNode2 ? "true" : "false"));
    }
}