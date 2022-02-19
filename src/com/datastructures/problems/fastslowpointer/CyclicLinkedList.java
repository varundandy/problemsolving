package com.datastructures.problems.fastslowpointer;

public class CyclicLinkedList {


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
        System.out.println("LinkedList has cycle: " + CyclicLinkedList.hasCycle(head) + "  Length: " + CyclicLinkedList.getLengthOfCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + CyclicLinkedList.hasCycle(head) + " Length: " + CyclicLinkedList.getLengthOfCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + CyclicLinkedList.hasCycle(head) + " Length: " + CyclicLinkedList.getLengthOfCycle(head));
    }

    private static Boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                return true; // found the cycle
            }
        }
        return false;
    }

    private static int getLengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean cycleExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleExists = true;
                // now u know cycle exists
                break;
            }
        }
        int count = 0;
        if (cycleExists) {
            ListNode iterator = slow;
            do {
                iterator = iterator.next;
                count++;
            } while (iterator != slow);

        }
        return count;

    }
}
