package org.example.lesson2.reverse.solve3;

import java.util.ArrayList;
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
class Solution {
    List<ListNode> nodes = new ArrayList<>();

    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        if (head != null) {
            ListNode node = head;
            while(node != null) {
                nodes.add(node);
                node = node.next;
            }

            int size = nodes.size();

            int startIdx = 0;
            int endIdx = size - 1;

            int middleIdx = size / 2;

            for (int i = startIdx; i < middleIdx; i++) {
                int curr = nodes.get(i).val;
                int end = nodes.get(endIdx - i).val;

                nodes.get(i).val = end;
                nodes.get(size - 1 - i).val = curr;
            }

            int currVal = nodes.get(startIdx).val;
            ListNode nextHead = nodes.get(startIdx).next;

            newNode = new ListNode(currVal, nextHead);
        }

        if(newNode == null) {
            return head;
        }

        return newNode;
    }

    public static void main(String[] args) {
        System.out.println("lesson 2 HW - 1 (solve 3)");

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