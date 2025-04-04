package com.datastructures.datastructures.graphs;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String args[]) {

        LinkedList<Crypto> list = new LinkedList<>();
        Crypto alts = new Crypto("Alts");
        Crypto xrp = new Crypto("XRP");
        Crypto xlm = new Crypto("XLM");
        Crypto icp = new Crypto("ICP");
        Crypto velo = new Crypto("VELO");
        Crypto shx = new Crypto("SHX");

        Graph graph = new Graph(6, 0);
        graph.addEdge(alts, xrp);
        graph.addEdge(alts, icp);
        graph.addEdge(xrp, xlm);
        graph.addEdge(xlm, velo);
        graph.addEdge(xlm, shx);
        graph.printGraph();
        List<Crypto> result = depthFirstSearch(graph, alts);
        result.stream().forEach(crypto -> System.out.println(crypto.toString()));

    }

    public static List<Crypto> depthFirstSearch(Graph graph, Crypto source) {
        List<Crypto> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.vertices];

        Stack<Crypto> stack = new Stack<>(graph.vertices);

        // Start DFS from the source
        stack.push(source);
        visited[source.getId()] = true;

        while (!stack.isEmpty()) {
            Crypto currentVertex = stack.pop();
            result.add(currentVertex);

            int currentIndex = currentVertex.getId();
            LinkedList<Crypto>.Node temp = graph.adjacencyList[currentIndex].head;
            while(temp !=null){
                Crypto neighbour = temp.data;
                if (!visited[neighbour.getId()]) {
                    stack.push(neighbour);
                    visited[neighbour.getId()] = true;
                }
                temp = temp.next;
            }
        }
        return result;
    }


    public static class Stack<T> {

        T[] array;
        int maxSize;
        int currentSize;
        int top;

        public Stack(int maxSize) {
            array = (T[]) new Object[maxSize];
            this.maxSize = maxSize;
            currentSize = 0;
            top = -1;
        }

        public void push(T data) {
            if (currentSize == maxSize) {
                System.out.println("Stack Full. Cant add more...");
            } else {
                array[++top] = data;
                currentSize++;
            }

        }

        public T pop() {
            T poppedItem = null;
            if (currentSize == 0) {
                System.out.println("Stack is Empty already. What the hell have you popped?!");
            } else {
                poppedItem = array[top];
                top--;
                currentSize--;
            }
            return poppedItem;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void printStack() {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(array[i].toString() + ((i == currentSize - 1) ? "" : ","));
            }
            System.out.println();
        }
    }

    public static class Crypto {
        private static int index = 0;
        private int id;
        String token;

        public Crypto(String token) {
            this.id = index++;
            this.token = token;
        }

        @Override
        public String toString() {
            return "Crypto{" +
                    "id=" + id +
                    ", token='" + token + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }
    }

    public static class LinkedList<T> {

        public class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;
        int size;

        public LinkedList() {
            this.head = null;
            size = 0;
        }

        public void insertAtHead(T data) {
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
            size++;
        }

        public void insertAtEnd(T data) {
            Node temp = this.head;
            if (temp == null) {
                insertAtHead(data);
                return;
            }
            Node newNode = new Node(data);
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }

        public void printList() {
            Node node = this.head;
            while (node != null) {
                System.out.print(node.data.toString() + ((node.next == null) ? "-> null" : "->"));
                node = node.next;
            }
            System.out.println();
        }


    }

    public static class Graph {

        int vertices;
        LinkedList<Crypto>[] adjacencyList;
        int source;

        public Graph(int vertices, int source) {

            this.vertices = vertices;
            this.source = source;
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }


        public void addEdge(Crypto source, Crypto destination) {

            if (source.getId() < vertices && destination.getId() < vertices) {
                this.adjacencyList[source.getId()].insertAtEnd(destination);
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
}
