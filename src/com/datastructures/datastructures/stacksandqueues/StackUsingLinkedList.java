package com.datastructures.datastructures.stacksandqueues;

public class StackUsingLinkedList {

    LinkedList stack;

    public StackUsingLinkedList() {
        stack = new LinkedList();
    }

    public void push(int element) {
        stack.insertNode(new LinkedListNode(element));
    }

    public int pop() {
        LinkedListNode removedNode = stack.removeNode();
        return removedNode.data;
    }

    public int peek() {
        LinkedListNode lastNodePushed = stack.peek();
        return lastNodePushed.data;
    }

    public void printList(){
        stack.printList();
    }


    public static void main(String args[]) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.printList();
        stack.push(2);
        stack.printList();
        System.out.println("Last Entered Node: " + stack.peek());
        stack.push(3);
        stack.printList();
        stack.push(4);
        stack.printList();
        int nodePopped = stack.pop();
        System.out.println("Node Popped: " + nodePopped);
        stack.printList();
        System.out.println("Last Entered Node: " + stack.peek());

    }


    public static class LinkedListNode {

        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {

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

        public LinkedListNode removeNode() {
            LinkedListNode nodePopped = null;
            if (this.head == null) {
                System.out.println();
            } else {
                nodePopped = this.head;
                this.head = this.head.next;
            }
            return nodePopped;
        }

        public LinkedListNode peek() {
            return this.head;
        }


        public void setLinkedList(int[] elements) {
            for (int i = 0; i < elements.length - 1; i++) {
                insertNode(new LinkedListNode(elements[i]));
            }
        }

        public void printList() {
            LinkedListNode node = this.head;
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
}
