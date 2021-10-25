package com.datastructures.hash;

public class CustomQueue {

    public static void main(String args[])
    {
        MyCustomQueue customQueue = new MyCustomQueue();
        Object result = customQueue.peek();
        customQueue.enqueue("Apples");
        customQueue.enqueue("Oranges");
        customQueue.enqueue("Pumpkin");
        customQueue.printQueue();
        customQueue.dequeue();
        customQueue.dequeue();
        customQueue.printQueue();

    }

    public static class MyCustomQueue {
        Node head;
        Node tail;
        int length;

     public MyCustomQueue()
        {
            this.head = null;
            this.tail = null;
            this.length = 0;
        }

        // return the last element in queue
        public Object peek ()
        {
            if (this.head != null) {
                return head.value;
            }
            return null;
        }

        //add element in Queue
        public MyCustomQueue enqueue (Object value) {
            Node newNode = new Node(value);
            if (this.length == 0) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
            }
            length++;
            return this;
        }

        //remove element in Queue First in will be first out
        public MyCustomQueue dequeue ()
        {
            if(length==0)
            {
                System.out.println("Queue is empty");
                return this;
            }
            this.head = this.head.next;
            length--;
            return this;
        }

        public void printQueue()
        {//Queue follows first in first out and hence we will output from the first node to the last.
            System.out.println("Length: " + length);
            if(length ==0)
            {
                System.out.println("Queue is empty");
                return;
            }
            if(length ==1)
           {
               System.out.println(head.value);
               return;
           }
            Node first = this.head;
            Node second= this.head.next;
            System.out.println(first.value);

            while(second != null)
            {
                System.out.println(second.value);
                second = second.next;
            }
        }
    }
    public static class Node{
        Object value;
        Node next;

        public Node(Object value)
        {
            this.value = value;
            this.next = null;
        }

    }
}



