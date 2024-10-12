package org.example.lesson2.reverse;

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

public class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode listNodeLast;
        listNodeLast = reverseRecursion(head, 0);

        return listNodeLast;
    }

    /**
     * Recursive method of reversal with preservation of all original objects.
     *
     * @param listNode List of Node.
     * @param i Number of iterations.
     * @return List of last Node, that is after reverse.
     */
    public ListNode reverseRecursion (ListNode listNode, int i) {
        if (listNode.next == null) return listNode;

        ListNode ListNodeNext = listNode.next;
        if(i == 0) listNode.next = null;

        ListNode ListNodeNextParent =  ListNodeNext.next;
        ListNodeNext.next = listNode;

        if(ListNodeNextParent == null) return ListNodeNext;

        ListNode ListNodeLast = reverseRecursion(ListNodeNextParent, ++i);
        ListNodeNextParent.next = ListNodeNext;

        return ListNodeLast;
    }

    /**
     * Reverse method using list, all reverse objects are new.
     *
     * @param listNode List of Node.
     * @return List of last Node, that is after reverse.
     */
    public ListNode reverseArrayList (ListNode listNode){

        List<ListNode> listNodes = new ArrayList<>();

        ListNode listNodeNext = listNode;
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
        System.out.println("lesson 2 HW - 1");

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

        ListNode newObjListNode = solution.reverseArrayList(listNodeStart);
        System.out.println("reverse with ArrayList");
        System.out.println(newObjListNode);
        System.out.println("new obj: " + (newObjListNode != listNode2 ? "true" : "false"));

        System.out.println("---");

        ListNode saveObjListNode = solution.reverseList(listNodeStart);
        System.out.println("reverse with Recursion");
        System.out.println(saveObjListNode);
        System.out.println("save obj: " + (saveObjListNode == listNode2 ? "true" : "false"));
    }
}
