package com.datastructures.datastructures.stacksandqueues;

public class QueueInArray {

    private int[] queueArray;
    private int size;
    private int front;
    private int rear;
    private int capacity;

    public QueueInArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        if ((rear + 1) % capacity == front) {
            return true;
        }
        return false;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow. Cannot enqueue the new element: "+element);
            return;
        }
        // If queue is empty, initialize front
        if (isEmpty()) {
            front = 0;
        }

        // Move rear to the next position in a circular manner
        rear = (rear + 1) % capacity;
        queueArray[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow. Cannot dequeue from this queue...");
            return -1;
        }

        int element = queueArray[front];
        // If the queue has only one element, reset the queue
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity; // Move front to the next position
        }

        size--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    // Get the front element without dequeuing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queueArray[front];
    }

    // Get the size of the queue
    public int size() {
        return size;
    }


    public static void main(String args[]) {

        QueueInArray queue = new QueueInArray(6);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Peek: " + queue.peek()); // Output: 10

        queue.dequeue(); // Dequeue 10
        queue.dequeue(); // Dequeue 20

        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70); // This will fail as the queue is full

        queue.dequeue(); // Dequeue 30
        System.out.println("Peek: " + queue.peek()); // Output: 40

    }
}
