package com.datastructures.patterns.patterns.fastslowpointers;

public class LinkedListMiddleNode {

    public static void main(String args[]) {

        int[] dataArray = {1, 2, 3, 4, 5, 6};
        int[][] input = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8, 10}, {1, 3, 5, 7, 9, 11},
                {0, 1, 2, 3, 4, 6}, {3, 4, 7, 9, 11, 14, 19}, {5, 1, 4, 9, 2, 3, 15, 16}};
        for (int i = 0; i < input.length - 1; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.createLinkedList(input[i]);
            PrintList.printLinkedList(list.head);
            int middleNodeData = middleNodeIndex(list);
            System.out.println();
            System.out.println(middleNodeData);
            System.out.println("-------------------");
        }
    }

    public static int middleNodeIndex(LinkedList list) {

        LinkedListNode slow = list.head;
        LinkedListNode fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }


    private static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }


    private static class LinkedList<T> {

        public LinkedListNode head;

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

        public void createLinkedList(int[] dataArray) {
            for (int i = dataArray.length - 1; i >= 0; i--) {
                LinkedListNode node = new LinkedListNode(dataArray[i]);
                this.insertNode(node);
            }
        }

    }

    private static class PrintList {

        static void printLinkedList(LinkedListNode head) {
            LinkedListNode node = head;
            while (node != null) {
                System.out.print(node.data);
                if (node.next != null) {
                    System.out.print("->");
                } else {
                    System.out.print("->null");
                }
                node = node.next;
            }
        }

    }

}






