package org.example.lesson2.brackets.solve2;

import java.util.*;

public class Solution {

    Map<String, String> map = new HashMap<>() {{
        put("(", ")");
        put("[", "]");
        put("{", "}");
    }};

    public boolean isValid(String s) {
        String[] arr = s.split("");

        if(arr.length % 2 != 0) return false;

        int countOpen = 0, countClose = 0;

        List<String> openBraces = new ArrayList<>();
        for (String current : arr) {
            if (isOpenParentheses(current)) {
                countOpen++;
                openBraces.add(current);
            }

            if (!openBraces.isEmpty()) {
                if (isCloseParentheses(current)) {
                    countClose++;
                    if (current.equals(")")) {
                        if (openBraces.getLast().equals("(")) {
                            openBraces.removeLast();
                        } else {
                            return false;
                        }
                    }

                    if (current.equals("]")) {
                        if (openBraces.getLast().equals("[")) {
                            openBraces.removeLast();
                        } else {
                            return false;
                        }
                    }

                    if (current.equals("}")) {
                        if (openBraces.getLast().equals("{")) {
                            openBraces.removeLast();
                        } else {
                            return false;
                        }
                    }
                }

            } else {
                return false;
            }
        }

        return compareCount(countOpen, countClose);
    }

    public boolean compareCount(int countOpen, int countClose) {
        return countOpen == countClose;
    }

    private boolean isCloseParentheses(String current) {
        return map.containsValue(current);
    }

    public boolean isOpenParentheses(String current) {
        return map.containsKey(current);
    }

    //============================================================
    public static void main(String[] args) {
        Solution solution = new Solution();
       extracted(solution);
        extracted1(solution);
        System.out.println(solution.isValid("(}{)")); // false 96
    }

    private static void extracted(Solution solution) {
        System.out.println(solution.isValid("()"));     // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("(]"));     // false
        System.out.println(solution.isValid("([])"));   // true
        System.out.println(solution.isValid("("));      // false
        System.out.println(solution.isValid("(("));     // false
        System.out.println("-------");
    }

    private static void extracted1(Solution solution) {
        System.out.println(solution.isValid("(([]){})"));   // true 80
        System.out.println(solution.isValid("(){}}{"));     // false 86
        System.out.println(solution.isValid("({{{{}}}))")); // false 95
        System.out.println(solution.isValid("[([]])"));     // false 98
        System.out.println(solution.isValid("){"));         // false 92
    }




}
