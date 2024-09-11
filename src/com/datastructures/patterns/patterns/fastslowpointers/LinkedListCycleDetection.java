package com.datastructures.patterns.patterns.fastslowpointers;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycleDetection {

    public static void main(String args[]) {

        int[][] input = {{1, 2,3, 4, 5, 6},{2, 4, 6, 8, 10, 12}, {1, 3, 5, 7, 9, 11},
                {0, 1, 2, 3, 4, 6}, {3, 4, 7, 9, 11, 17}, {5, 1, 4, 9, 2, 3}};
        int[] pos = {0, -1, 1, -1, 2};
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        if(head == null || slow.next==null){
            return false;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}


class LinkedListNode {

    public int data;
    public LinkedListNode next;

    LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

}

class LinkedList<T> {

    LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNode(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNode(newNode);
        }
    }

    public static int getLength(LinkedListNode head) {
        LinkedListNode next = head;
        int count = 0;
        while (next != null) {
            count++;
            next = next.next;
        }
        return count;
    }

    public static LinkedListNode getNode(LinkedListNode head, int pos) {
        LinkedListNode ptr = head;
        if (pos != -1) {
            int p = 0;
            while (p < pos) {
                ptr = ptr.next;
                p += 1;
            }
            return ptr;
        }
        return ptr;
    }
}

class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            } else {
                // if this is the last node, print null at the end
                System.out.print(" → null \n ");
            }
        }
    }

    public static void printListWithForwardArrowLoop(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
    }
}