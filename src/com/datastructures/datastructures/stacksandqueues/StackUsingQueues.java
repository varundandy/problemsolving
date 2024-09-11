package com.datastructures.datastructures.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        this.q1 = new LinkedList();
    }

    public void push(int x) {
        // Add the new element to q2
        q2.offer(x);

        // Transfer all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap q1 and q2 so that q1 has the stack elements in correct order
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove the element on top of the stack and return it
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.poll();
    }

}
