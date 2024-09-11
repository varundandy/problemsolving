package com.datastructures.datastructures.stacksandqueues;

/**
 * Deque allows insertion and deletion at both ends unlike queue which only allows insertion at the end and deletion from the front...
 */
public class DequeUsingArray {

    private int[] dequeArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public DequeUsingArray(int capacity) {
        this.dequeArray = new int[capacity];
        this.capacity = capacity;
        this.rear = -1;
        this.front = -1;
        this.size = 0;
    }

    public boolean isFull() {
        if ((rear + 1) % capacity == front) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueueRear(int element) {

        // Queue Overflow
        if (isFull()) {
            System.out.println("Queue Overflow. Cannot enqueue element: " + element);
        }

        // initialize the front to zero since this is the first element being added
        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        this.dequeArray[rear] = element;
        size++;
        System.out.println("Enqueued on Rear: " + element);
    }

    public int dequeueFront() {

        // Queue Underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow. Cannot dequeue.");
        }


        int elementDequeued = this.dequeArray[front];
        front = (front + 1) % capacity;
        size--;
        // if only one element in the list then reset pointers.
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        System.out.println("Dequeued from Front: " + elementDequeued);
        return elementDequeued;
    }

    public void enqueueFront(int element) {

        // Queue Overflow
        if (isFull()) {
            System.out.println("Queue Overflow. Cannot enqueue element: " + element);
        }

        // initialize the front to zero since this is the first element being added
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }

        front = (front - 1 + capacity) % capacity;
        this.dequeArray[front] = element;
        size++;
        System.out.println("Enqueued on Front: " + element);
    }

    public int dequeueRear() {

        // Queue Overflow
        if (isEmpty()) {
            System.out.println("Queue Underflow. Cannot dequeue");
        }

        // initialize the front to zero since this is the first element being added
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        int elementDequeued = this.dequeArray[rear];
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return elementDequeued;
    }

    // Function to display the deque elements (for debugging purposes)
    public void displayDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Deque elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(dequeArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

// Create a deque with capacity 5
        DequeUsingArray deque = new DequeUsingArray(5);

        // Insert elements into the deque
        deque.enqueueRear(10);  // Deque: [10]
        deque.enqueueRear(20);  // Deque: [10, 20]
        deque.enqueueFront(30); // Deque: [30, 10, 20]
        deque.enqueueRear(40);  // Deque: [30, 10, 20, 40]

        // Display the current state of the deque
        System.out.println("Initial Deque:");
        deque.displayDeque();  // Output: [30, 10, 20, 40]

        // Remove elements from the deque
        System.out.println("\nDequeueing from front: " + deque.dequeueFront()); // Removes 30
        System.out.println("Dequeueing from rear: " + deque.dequeueRear());    // Removes 40

        // Display the current state after dequeuing
        System.out.println("\nDeque after removing front and rear:");
        deque.displayDeque();  // Output: [10, 20]

        // Add more elements to test circular behavior
        deque.enqueueFront(50); // Deque: [50, 10, 20]
        deque.enqueueRear(60);  // Deque: [50, 10, 20, 60]
        deque.enqueueRear(70);  // Deque: [50, 10, 20, 60, 70] (deque is now full)

        // Display the deque after all insertions
        System.out.println("\nDeque after enqueuing more elements:");
        deque.displayDeque();  // Output: [50, 10, 20, 60, 70]

        // Try to enqueue when the deque is full (should trigger overflow message)
        deque.enqueueRear(80); // This will print "Deque Overflow"

        // Remove all elements to test underflow
        deque.dequeueFront(); // Removes 50
        deque.dequeueFront(); // Removes 10
        deque.dequeueFront(); // Removes 20
        deque.dequeueFront(); // Removes 60
        deque.dequeueFront(); // Removes 70

        // Display the empty deque
        System.out.println("\nDeque after removing all elements:");
        deque.displayDeque();

    }
}
