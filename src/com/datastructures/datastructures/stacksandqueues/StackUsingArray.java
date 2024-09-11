package com.datastructures.datastructures.stacksandqueues;


/*
 * Initially empty Stack stored in an array S[1....6]
 * Operations
 * PUSH(S, 4)
 * PUSH(S, 1)
 * PUSH(S, 3)
 * POP(S)
 * PUSH(S, 8)
 * POP(S)
 * */

public class StackUsingArray {

    private int[] stackArray = new int[6];
    private int top = -1;

    public void push(int value) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack is full mate...Cant add anything more...");
        } else {
            stackArray[++top] = value;

        }
    }

    public int pop() {
        int valuePopped = -1;
        if (top == 0) {
            System.out.println("Stack is empty mate...Cant pop out anything...");
        } else {
            valuePopped = stackArray[top];
            top--;
        }
        return valuePopped;
    }

    public void printStack() {
        for (int i = 0; i <= this.top; i++) {
            System.out.print(this.stackArray[i]);
            if (i != this.top) {
                System.out.print("-");
            }
        }
        System.out.println();
        System.out.println("------------");
    }

    public static void main(String args[]) {

        StackUsingArray stack = new StackUsingArray();
        stack.push(4);
        stack.printStack();
        stack.push(1);
        stack.printStack();
        stack.push(3);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.push(8);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }

}
