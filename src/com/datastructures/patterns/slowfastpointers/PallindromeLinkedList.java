package com.datastructures.patterns.slowfastpointers;

import java.util.ArrayList;
import java.util.List;

public class PallindromeLinkedList {

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 2, 1}, {4, 7, 9, 5, 4},
                {2, 3, 5, 5, 3, 2}, {6, 1, 0, 5, 1, 6}, {3, 6, 9, 8, 4, 8, 9, 6, 3}};
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.createLinkedList(input[i]);
            boolean result = palindrome(list.head);
            results.add(result);
        }
        System.out.println(results);
    }

    public static boolean palindrome(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next;
            }
        }
        // here fast would be null and slow will be pointing on the middle element.
        System.out.println(slow.data);
        System.out.println(fast.data);
        System.out.println("-----------------");
        LinkedListNode reverseLinkedHeadNode = LinkedListReversal.reverseLinkedList(slow);
        boolean result = compareTwoHalves(head, reverseLinkedHeadNode);
        return result;
    }

    public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
        // Compare the corresponding nodes of the first and second halves of the linked list
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


        }
        return true;
    }


}

class LinkedListReversal {
    static LinkedListNode reverseLinkedList(LinkedListNode slowPtr) {
        LinkedListNode prev = null;
        LinkedListNode next = null;
        LinkedListNode curr = slowPtr;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}




