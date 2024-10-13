package org.example.lesson2.reverse;

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
 * Recursive method of reversal with preservation of all original objects.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode listNodeLast;
        listNodeLast = reverseRecursion(head, 0);

        return listNodeLast;
    }

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

        ListNode saveObjListNode = solution.reverseList(listNodeStart);
        System.out.println("reverse with Recursion");
        System.out.println(saveObjListNode);
        System.out.println("save obj: " + (saveObjListNode == listNode2 ? "true" : "false"));
    }
}
