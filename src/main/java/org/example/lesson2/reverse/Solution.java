package org.example.lesson2.reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
