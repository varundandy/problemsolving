package com.datastructures.problems;

import javax.swing.*;

public class AddTwoNumbers {

    public static void main(String args[]) {

        //Case 1
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        //Case 2
        //ListNode l1 = new ListNode(0);
        //ListNode l2 = new ListNode();
        //Case 3
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 != null && l2!=null) {
            ListNode result = new ListNode();
            int value1 = covertListToNumber(l1);
            int value2 = covertListToNumber(l2);
            int finalValue = value1 + value2;
            System.out.print(finalValue);
            result = convertNumberToList(finalValue);
            return result;
        }
        return l1 != null ? l1 : (l2 != null ? l2: null);
    }

    private static ListNode convertNumberToList(int finalValue) {
        // 807 7-> 0 -> 8 /// 817
        int power = 1;
        ListNode one = null;

        int nodeValue = finalValue % Double.valueOf(Math.pow(10, power)).intValue();
        finalValue = (finalValue - nodeValue) / 10;
        one = new ListNode(nodeValue);
        ListNode temp = one;
        while(finalValue !=0) {
            nodeValue = finalValue % Double.valueOf(Math.pow(10, power)).intValue();
            finalValue = (finalValue - nodeValue) / 10;
            temp.next =  new ListNode(nodeValue);
            temp = temp.next;
        }

        return one;
    }

    private static int covertListToNumber(ListNode l) {
        int value = 0;
        int power = 0;

        while (l.next != null) {
            value = value + (l.val * (Double.valueOf(Math.pow(10, power)).intValue()));
            l = l.next;
            power++;
        }
        value = value + (l.val * (Double.valueOf(Math.pow(10, power)).intValue()));
        return value;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

}
