package com.datastructures.datastructures.stacksandqueues;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int size;

    public QueueUsingStacks() {
        s1 = new Stack();
        s2 = new Stack();
        size = 0;
    }

    public void enqueue(int element) {
        s1.push(element);
        size++;
    }

    public int dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Pop the top element from s2 (which is the front of the queue)
        if (s2.isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue from an empty queue");
            return -1;  // Indicating underflow
        }
        int elementRemoved = s2.pop();

        // Move all elements back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return elementRemoved;
    }

    public void display() {
        System.out.print(Arrays.toString(s1.toArray()));
    }


    public static void main(String args[]) {

        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.display();
    }


}
