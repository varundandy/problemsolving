package com.datastructures.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicLinkedList {


    public static void main(String args[]) {

        Node six = new Node(6, null);
        Node five = new Node(5, six);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        six.setNext(three);
        printLinkedListElements(one);
        Node result = isCyclic(one);
        printLinkedListElements(result);

    }

    private static Node isCyclic(Node head) {

        Node hare = head, tortoise = head;
        while (true) {
            hare = hare.next;
            tortoise = head.next;
            if (hare == null || hare.next == null) {
                return null;
            }
            hare = hare.next;
            if (hare == tortoise) {
                break;
            }
        }
        Node p1 = head, p2 = tortoise;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
