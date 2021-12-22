package com.datastructures.problems.stackandqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack using queues.
 */
public class StackUsingQueues {

    public static class Stack {
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        int size = 0;

        // 4(0),5(1),6(2),1(3)
        //O(1)
        public void push(int value) {
            queue1.add(value);
            size++;
        }

        //O(n)
        public Integer pop() {
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }
                int lastVal = queue1.poll();
                System.out.println("Element Popped: " + lastVal);
                Queue<Integer> q = queue1;
                queue1 = queue2;
                queue2 = q;
                return lastVal;
            }


            public static void main(String args[])
            {
                Stack stack = new Stack();
                stack.push(5);
                stack.push(8);
                stack.push(11);
                stack.push(4);
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
            }


        }


    }
