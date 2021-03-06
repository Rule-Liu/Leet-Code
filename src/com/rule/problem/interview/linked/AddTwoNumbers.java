package com.rule.problem.interview.linked;


/**
 * 002. 两数相加
 */
public class AddTwoNumbers {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //solution 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str1 = new StringBuilder();
        int bit = 0;
        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int s = l1.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            int s = l2.val + bit;
            str1.append(s % 10);
            bit = s >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if (bit != 0) {
            str1.append(bit);
        }

        StringBuilder reverse = str1.reverse();
        if (reverse.length() == 1 && "0".equals(reverse.toString())) {
            return new ListNode(0);
        }
        int len = reverse.length();
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(str1.charAt(--len))));
        ListNode res = head;
        while (len > 0) {
            int val = Integer.parseInt(String.valueOf(str1.charAt(--len)));
            head.next = new ListNode(val);
            head = head.next;
        }
        return res;
    }

    // solution 2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + bit;
            head.next = new ListNode(s % 10);
            head = head.next;
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int s = l1.val + bit;
            head.next = new ListNode(s % 10);
            head = head.next;
            bit = s >= 10 ? 1 : 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            int s = l2.val + bit;
            head.next = new ListNode(s % 10);
            head = head.next;
            bit = s >= 10 ? 1 : 0;
            l2 = l2.next;
        }
        if (bit != 0) {
            head.next = new ListNode(bit);
        }
        return res.next;
    }
    public static void main(String[] args) {
    }

}
