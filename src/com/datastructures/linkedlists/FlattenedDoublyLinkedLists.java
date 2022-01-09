package com.datastructures.linkedlists;

import java.nio.file.NotDirectoryException;

public class FlattenedDoublyLinkedLists {

    public static void main(String args[]) {
        Node input = new Node(1, null, null, null);
        input = getFlattenedList(input);


    }

    /**
     * T: O(N)
     * S: O(1)
     * */
    private static Node getFlattenedList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.child == null) {
                currentNode = currentNode.next;
            } else {
                Node target = currentNode.next;
                Node tail = currentNode.child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                currentNode.next = currentNode.child;
                if (currentNode.child != null) {
                    currentNode.child.prev = currentNode;
                }
                tail.next = target;
                if(target!=null) {
                    target.prev = tail;
                }
                currentNode.child = null;
            }
        }
    return head;
    }


    public static class Node {

        private Integer value;
        private Node next;
        private Node prev;
        private Node child;

        public Node(Integer value, Node prev, Node next, Node child) {
            this.value = value;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

    }
}
