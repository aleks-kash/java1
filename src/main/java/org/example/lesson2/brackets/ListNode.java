package org.example.lesson2.brackets;

public class ListNode {
    char val;
    ListNode pre;

    public ListNode(char val) { this.val = val; }
    public ListNode(char val, ListNode pre) { this.val = val; this.pre = pre; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", pre=" + pre +
                '}';
    }
}
