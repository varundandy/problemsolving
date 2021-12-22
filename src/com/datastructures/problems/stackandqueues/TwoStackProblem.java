package com.datastructures.problems.stackandqueues;

import java.util.Arrays;

/**
 * How to implement 2 Stacks in one Array. A[1....n] in such a way that neither stack overflows
 * unless the total number of elements in both stacks together is n. PUSH and POP should be O(n)
 */
public class TwoStackProblem {

    int array[];
    int top1, top2;

    public TwoStackProblem(int sizeOfArray) {
        array = new int[sizeOfArray];
        top1 = -1;
        top2 = sizeOfArray;
    }

    public void push1(int val) {
        if (top1 < top2 -1 ) {
            array[++top1] = val;
        } else {
            System.out.println("Stack is full, couldn't add " + val);
        }

    }

    public void push2(int val) {
        if (top1 < top2 -1 ) {
            array[--top2] = val;
        } else {
            System.out.println("Stack is full, couldn't add " + val);
        }
    }

    public int pop1() {
       int value= array[top1];
       top1--;
       return value;
    }

    public int pop2() {
        int value= array[top2];
        top2++;
        return value;
    }

    public static void main(String args[]) {

        TwoStackProblem stacks = new TwoStackProblem(5);
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);
        stacks.push2(4);
        stacks.push2(5);
        stacks.push2(6);
        stacks.pop1();
        stacks.push2(7);

        System.out.println(Arrays.toString(stacks.array));

    }


}
