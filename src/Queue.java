//Class for queue
public class Queue {
    private int rear, front, size;
    private double[] queue;
    private int capacity;

    // Constructor to initialize the queue
    Queue(int capacity) {
        front = size = 0;
        rear = -1;
        this.capacity = capacity;
        queue = new double[capacity];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (size == capacity);
    }

    // Add an element to the queue
    public void enqueue(double data) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
            System.out.println("Element added: " + data + ", to position: " + rear);
        } else {
            System.out.println("Queue is full.");
        }
    }

    // Remove an element from the queue
    public void dequeue() {
        if (!isEmpty()) {
            double removedElement = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Element removed: " + removedElement + ", size: " + size);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    // Print all elements in the queue
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = front;
        int elementsCount = size;
        while (elementsCount > 0) {
            System.out.println(queue[i]);
            i = (i + 1) % capacity;
            elementsCount--;
        }
    }
}