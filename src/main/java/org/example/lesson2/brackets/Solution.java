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

        return true;
    }
}
