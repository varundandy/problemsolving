package com.datastructures.problems.stackandqueues;

import java.util.Stack;

public class QueueUsingStack {

    public static class Queue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int size = 0;

//O(1)
        public void enqueue(int value) {
            s1.push(value);
            size++;
        }

        ///O(2n) -> O(n)
        public Integer dequeue() {

            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            int valueRemoved = s2.pop();
            System.out.println("Value Removed: " + valueRemoved);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
            return valueRemoved;
        }

        public static void main(String args[]) {

            Queue queue = new Queue();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();


        }
    }
}