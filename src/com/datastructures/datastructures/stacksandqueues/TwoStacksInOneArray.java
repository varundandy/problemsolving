package com.datastructures.datastructures.stacksandqueues;

public class TwoStacksInOneArray {

    private int[] stackArray;
    private int s1top;
    private int s2top;
    int size;

    public TwoStacksInOneArray(int n) {
        this.stackArray = new int[n];
        s1top = -1;
        s2top = n;
        size = n;
    }

    public void push1(int value) {
        if (s1top + 1 < s2top) {
            this.stackArray[++s1top] = value;
        } else {
            System.out.println("Cannot add the value " + value+". The stack is full mate...");
        }
    }

    public int pop1() {
        int poppedValue = 0;
        if (s1top == -1) {
            System.out.println("Stack is empty mate...What have you popped!?!?");
        } else {
            poppedValue = this.stackArray[s1top];
            s1top--;
        }
        return poppedValue;
    }

    public void push2(int value) {
        if (s2top - 1 > s1top) {
            this.stackArray[--s2top] = value;
        } else {
            System.out.println("Cannot add the value " + value+". The stack is full mate...");
        }
    }

    public int pop2() {
        int poppedValue = 0;
        if (s2top == size) {
            System.out.println("Stack is empty mate...What have you popped!?!?");
        } else {
            poppedValue = this.stackArray[s2top];
            s1top++;
        }
        return poppedValue;
    }

    public void printStacks(){
        for(int i= 0; i<=this.stackArray.length-1;i++)
        {
            System.out.print(this.stackArray[i]);
        }
        /*for(int i= 0; i<=s1top;i++)
        {
            System.out.print(this.stackArray[i]);
        }
        System.out.print("|");
        for(int i= s2top; i<=this.stackArray.length-1;i++)
        {
            System.out.print(this.stackArray[i]);
        }*/
    }

    public static void main(String args[]){

        TwoStacksInOneArray stacks = new TwoStacksInOneArray(9);
        stacks.pop1();
        stacks.pop2();
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);
        stacks.push2(4);
        stacks.push2(5);
        stacks.push2(6);
        stacks.push1(7);
        stacks.push2(8);
        stacks.push1(9);
        stacks.push2(10);
        stacks.pop1();
        stacks.push2(10);
        stacks.printStacks();
    }

}
