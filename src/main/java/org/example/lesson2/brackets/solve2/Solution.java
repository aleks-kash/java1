package org.example.lesson2.brackets.solve2;

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
    public ListNode reverseList(ListNode head) {

        if(head != null) {

            int current = head.val; // 1
            //int next = head.next.val; // 2
            int temp = current;

            //System.out.println(current);
            //System.out.println(next);

            //head.val = next;
            //head.next.val = temp;

        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        for (ListNode listNode : list) {
            System.out.println(listNode.val);
        }

        solution.reverseList(head);


        //Input: head = [1,2]
        //Output: [2,1]

        //Input: head = []
        //Output: []
        System.out.println();
    }
}