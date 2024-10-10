package org.example;

import org.example.lesson2.reverse.Solution;
import org.example.lesson2.reverse.ListNode;

public class Main
{
    public static void main(String[] args) {

        runHW1();
        System.out.println("-------------------------------------------------------------------------------------");
        runHW2();
        System.out.println("-------------------------------------------------------------------------------------");
        runHW3();
    }

    private static void runHW1(){
        // 1
        System.out.println("HW - 1");

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

    private static void runHW2(){
        // 2

        System.out.println("HW - 2");

        String s1 = "(()(({}{{{[]}}})())){}";
        String s2 = "(()(({}{{{[]}}})())){}{";

        org.example.lesson2.brackets.Solution solutionBrackets = new org.example.lesson2.brackets.Solution();

        System.out.println("---");

        System.out.println("isValid: " + s1 + " //true");
        System.out.println(solutionBrackets.isValid(s1));

        System.out.println("---");

        System.out.println("isValid: " + s2 + " //false");
        System.out.println(solutionBrackets.isValid(s2));
    }

    private static void runHW3() {
        // 3
        System.out.println("HW - 3");
    }
}