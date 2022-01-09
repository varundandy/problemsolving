package com.datastructures.problems.stackandqueues;

import java.util.Arrays;
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

        public Integer pop(){
            while(!s1.empty())
            {
                s2.push(s1.pop());
            }

            int value = s2.pop();
            while(!s2.empty())
            {
                s1.push(s2.pop());
            }
            size--;
            return value;
        }

        public Integer peek(){
            while(!s1.empty())
            {
                s2.push(s1.pop());
            }
            int value = s2.peek();
            while(!s2.empty())
            {
                s1.push(s2.pop());
            }
            return value;
        }

        /**
         * T: O(1)
         * S: O(1)
         * */
        public void push(Integer value){
            s1.push(value);
            size++;
        }

        /**
         * T: O(1)
         * S: O(1)
         * */
        public boolean empty()
        {
           return s1.empty();
        }


        public static void main(String args[]) {
            Queue queue = new Queue();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            System.out.println("Is queue Empty: "+ queue.empty());
            queue.push(4);
            queue.push(5);
            queue.push(6);
            queue.push(7);
            queue.push(8);
            queue.push(9);
            queue.pop();
            queue.pop();
            queue.pop();
            System.out.println(queue.peek());
            queue.printQueue();
        }

        private void printQueue() {
           System.out.println(Arrays.toString(s1.toArray()));
        }
    }
}