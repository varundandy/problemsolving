package com.datastructures.patterns.patterns.fastslowpointers;

public class LinkedListPallindrome {

    public static void main(String args[]) {

        int[][] inputDatas = {{4, 5, 6, 5, 4}, {1, 2, 3, 4, 5, 4, 3, 2, 2}, {3, 4, 5, 6, 7, 6, 5, 4, 3}};
        for (int i = 0; i < inputDatas.length; i++) {
            LinkedList list = new LinkedList();
            list.createLinkedList(inputDatas[i]);
            PrintList.printLinkedList(list);
            boolean result = isPallindrome(list);
            System.out.println("Is Pallindrome: " + result);
        }
    }


    public static Boolean isPallindrome(LinkedList list) {

        LinkedListNode slow = list.head;
        LinkedListNode fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle Node: " + slow.data);
        LinkedListNode reversedLinkedList = LinkedListUtil.reverseLinkedList(slow);
        boolean result = compareTwoHalves(list.head, reversedLinkedList);
        return result;
    }

    private static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {

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

    static class LinkedList {

        LinkedListNode head;

        public LinkedList() {
            this.head = null;
        }

        public void insertNode(LinkedListNode node) {
            if (head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }

        public void createLinkedList(int[] inputData) {
            for (int i = inputData.length - 1; i >= 0; i--) {
                insertNode(new LinkedListNode(inputData[i]));
            }
        }

    }

    static class LinkedListNode {

        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }

    }

    static class PrintList {

        public static void printLinkedList(LinkedList list) {
            LinkedListNode node = list.head;
            while (node != null) {
                System.out.print(node.data);
                if (node.next != null) {
                    System.out.print("->");
                } else {
                    System.out.print("-> null");
                }

                node = node.next;
            }
            System.out.println();
        }
    }

    static class LinkedListUtil {

        public static LinkedListNode reverseLinkedList(LinkedListNode start) {

            LinkedListNode prev = null;
            LinkedListNode next = null;
            LinkedListNode current = start;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;

        }
    }

}
