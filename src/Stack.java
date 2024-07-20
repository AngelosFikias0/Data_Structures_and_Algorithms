//Class for stack
public class Stack {
    private int top;
    private double[] element;
    private int capacity;

    // Constructor to initialize the stack with a specific size
    public Stack(int size) {
        top = 0;
        element = new double[size];
        capacity = size;
    }

    // Method to push an element onto the stack
    public void push(double value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            element[top] = value;
            top++;
            System.out.println("Added element: " + value + " , top counter: " + top);
        }
    }

    // Method to pop an element from the stack
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
            double removedElement = element[top];
            System.out.println("Removed element: " + removedElement + " , top counter: " + top);
        }
    }

    // Method to peek at the top element of the stack
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top item: " + element[top - 1]);
        }
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == capacity);
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == 0);
    }
    
    // Method to get the current size of the stack
    public int size() {
        return top;
    }
}
