package com.datastructures.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class BFS {

    public static void main(String args[]) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.printGraph();
        List<Integer> result = BFSTraversal(graph);
        result.stream().forEach(System.out::print);
    }

    public static List<Integer> BFSTraversal(Graph graph) {

        List<Integer> result = new ArrayList<>();
        int numVertices = graph.vertices;
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new Queue<>(numVertices);

        int source = 0;
        // Enqueue the source vertex and mark it as visited
        queue.enqueue(source);
        visited[source] = true;

        //start BFS
        while (!queue.isEmpty()) {

            int currentVertex = queue.dequeue();
            result.add(currentVertex);

            LinkedList<Integer>.Node node = graph.adjacencyList[currentVertex].head;

            while (node != null) {
                if (!visited[node.data]) {
                    queue.enqueue(node.data);
                    visited[node.data] = true;
                }
                node = node.next;
            }
        }
        return result;
    }


    public static class LinkedList<T> {

        public class Node {
            public T data;
            public Node next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public Node head;
        public int size;

        public LinkedList() {
            this.head = null;
        }

        public boolean isEmpty() {
            return this.head == null;
        }

        public int getSize() {
            return size;
        }

        public Node getHeadNode() {
            return head;
        }

        public void insertAtHead(T data) {
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
            size++;
        }

        public void insertAtEnd(T data) {
            if (isEmpty()) {
                insertAtHead(data);
                return;
            }
            Node newNode = new Node(data);
            Node lastNode = this.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            size++;
        }

        public void printList() {
            if (isEmpty()) {
                System.out.println("null");
                return;
            }
            Node node = this.head;
            while (node != null) {
                System.out.print(node.data.toString() + "->");
                node = node.next;
            }
            System.out.println("null");
        }

        public void deleteAtHead() {
            if (isEmpty()) {
                System.out.println("List is empty mate...");
                return;
            }
            this.head = this.head.next;
            size--;
        }

        public void deleteAtTail() {
            if (isEmpty()) {
                System.out.println("List is empty mate...");
                return;
            }
            if (this.head.next == null) { // if it is only one node then simply point head to null;
                this.head = null;
            } else { // if not find the second last element and mark the next as null for the same.
                Node secondLast = this.head;
                while (secondLast.next.next != null) {
                    secondLast = secondLast.next;
                }
                secondLast.next = null;
            }
            size--;
        }

    }

    public static class Graph {

        public int vertices; // count of vertices
        public LinkedList<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            if (source < vertices && destination < vertices) {
                this.adjacencyList[source].insertAtEnd(destination);

                //for a undirected graph
                //this.adjacencyList[destination].insertAtEnd(source);
            }
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                System.out.print("|" + i + "| => ");
                if (adjacencyList[i] == null) {
                    System.out.print("null");
                } else {
                    adjacencyList[i].printList();
                }
            }
        }
    }

    public static class Queue<V> {
        private int maxSize;
        private V[] array;
        private int front;
        private int back;
        private int currentSize;

        public Queue(int maxSize) {
            this.maxSize = maxSize;
            array = (V[]) new Object[maxSize];
            front = 0;
            back = -1;
            currentSize = 0;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }

        public void enqueue(V value) {
            if (isFull()) return;
            back = (back + 1) % maxSize; //to keep the index in range
            array[back] = value;
            currentSize++;
        }

        public V dequeue() {
            if (isEmpty()) return null;

            V temp = array[front];
            front = (front + 1) % maxSize; //to keep the index in range
            currentSize--;

            return temp;
        }
    }
}
