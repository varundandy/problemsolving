package com.datastructures.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListMNReversals {

    public static void main(String args[]) {
        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));
        System.out.println("Before: ");
        printLinkedListElements(linkedList);
        linkedList = reverseMN(linkedList, 2, 6);
        Node linkedList2 = reverseMN2(linkedList, 2, 6);
        System.out.println("After: ");
        printLinkedListElements(linkedList);
        printLinkedListElements(linkedList2);
    }

    private static Node reverseMN(Node head, int m, int n) {
        Node currentNode = head;
        Node prev = null;
        Node start = null;
        Node tail = null;
        Node source = null;
        Node target = null;
        Node preTarget = null;
        int i = 1;
        while (currentNode != null) {
            if (i == m) {
                start = prev;
                source = currentNode;
            }
            if (i == n) {
                preTarget = prev;
                tail = currentNode.next;
                target = currentNode;
            }
            prev = currentNode;
            currentNode = currentNode.next;
            i++;
        }
        start.next = target;
        target.next = source.next;
        preTarget.next = source;
        source.next = tail;
        return head;
    }

    private static Node reverseMN2(Node head, int m, int n) {
        int currentPos = 1;
        Node currentNode = head;
        Node start = head;

        while (currentPos < m)
        {
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }

        Node newList = null;
        Node tail = currentNode;
        while(currentPos >=m && currentPos <=n)
        {
            Node next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPos++;
        }

        start.next = newList;
        tail.next = currentNode;
        if (m > 1) {
            return head;
        } else {
            return newList;
        }

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
