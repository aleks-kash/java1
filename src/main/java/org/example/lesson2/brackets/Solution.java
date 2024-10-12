package org.example.lesson2.brackets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<AllowedBrackets> allowedBracketsList = new ArrayList<>();

    public Solution() {
        allowedBracketsList.add(new AllowedBrackets('(', ')'));
        allowedBracketsList.add(new AllowedBrackets('[', ']'));
        allowedBracketsList.add(new AllowedBrackets('{', '}'));
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();

        if (charArray.length % 2 != 0)
            return false;

        ListNode preListNode = null;
        for (char b : charArray) {

            boolean isFound = false;

            for (AllowedBrackets allowedBrackets : allowedBracketsList) {
                if (allowedBrackets.opening == b) {
                    if (preListNode == null)
                        preListNode = new ListNode(b);
                    else
                        preListNode = new ListNode(b, preListNode);
                    isFound = true;
                    break;
                } else if (allowedBrackets.closing == b) {
                    if (preListNode == null) {
                        return false;
                    }
                    if (preListNode.val == allowedBrackets.opening) {
                        preListNode = preListNode.pre;
                        isFound = true;
                        break;
                    } else {
                        return false;
                    }
                }
            }

            if (!isFound) {
                return false;
            }
        }

        return preListNode == null;
    }

    public static void main(String[] args) {
        System.out.println("lesson 2 HW - 2");

        String s1 = "(()(({}{{{[]}}})())){}";
        String s2 = "(()(({}{{{[]}}})())){}{";
        String s3 = "(()(({}{{{[]}}})())){}{{";

        Solution solutionBrackets = new Solution();

        System.out.println("---");

        System.out.println("isValid: " + s1 + " //true");
        System.out.println(solutionBrackets.isValid(s1));

        System.out.println("---");

        System.out.println("isValid: " + s2 + " //false");
        System.out.println(solutionBrackets.isValid(s2));

        System.out.println("---");

        System.out.println("isValid: " + s3 + " //false");
        System.out.println(solutionBrackets.isValid(s3));
    }
}
