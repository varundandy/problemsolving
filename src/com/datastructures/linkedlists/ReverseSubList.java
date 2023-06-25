package com.datastructures.linkedlists;

public class ReverseSubList {


    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

    }

    private static Node reverse(Node head, int startLimit, int endLimit) {

        Node currentNode = head;

return null;
    }
}


class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}