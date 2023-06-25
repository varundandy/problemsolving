package com.datastructures.problems.fastslowpointer;

import java.util.*;

public class LinkedListCycleStart {


    public static class ListNode {

        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        List<Object> triplet = LinkedListCycleStart.fetchListDetails(head);
        System.out.println("LinkedList has cycle: " + triplet.get(0) + "  Length: " + triplet.get(1) + " Starting Node: " + triplet.get(2));

        head.next.next.next.next.next.next = head.next.next;
        triplet = LinkedListCycleStart.fetchListDetails(head);
        System.out.println("LinkedList has cycle: " + triplet.get(0) + "  Length: " + triplet.get(1) + " Starting Node: " + triplet.get(2));

        head.next.next.next.next.next.next = head.next.next.next;
        triplet = LinkedListCycleStart.fetchListDetails(head);
        System.out.println("LinkedList has cycle: " + triplet.get(0) + "  Length: " + triplet.get(1) + " Starting Node: " + triplet.get(2));


    }

    private static List<Object> fetchListDetails(ListNode head) {
        List<Object> triplet = new ArrayList<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                triplet.add(Boolean.TRUE);
                int length = computeLength(slow);
                triplet.add(length);
                triplet.add(getStartNode(head, length));
                break;
            }
        }
        if(triplet.isEmpty())
        {
            triplet.add(Boolean.FALSE);
            triplet.add("N/A");
            triplet.add("N/A");
        }
        return triplet;
    }

    private static Integer getStartNode(ListNode head, int length) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for(int i = 0; i < length ; i++) {
            pointer2 = pointer2.next;
        }
        while(pointer1 != pointer2)
        {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1.value;
    }

    public static Integer computeLength(ListNode slow) {
        ListNode iterator = slow;
        int count = 0;
        do {
            iterator = iterator.next;
            count++;
        } while (iterator != slow);

        return count;
    }

}
