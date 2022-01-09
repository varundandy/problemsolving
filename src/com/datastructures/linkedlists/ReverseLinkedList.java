package com.datastructures.linkedlists;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

    public static void main(String args[]) {

        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println("Before: ");
        printLinkedListElements(linkedList);
        linkedList = reverseList(linkedList);
        System.out.println("After: ");
        printLinkedListElements(linkedList);
    }

    private static Node reverseList(Node linkedList) {
        Node currentNode = linkedList;
        Node prev = null;
        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    private static void printLinkedListElements(Node linkedList) {
        Node currentNode = linkedList;
        List<Integer> values = new ArrayList<>();
        while (currentNode != null) {
            values.add(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println(Arrays.toString(values.toArray()));
    }


    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value, Node node) {
            this.value = value;
            this.next = node;
        }
    }
}
