//Class for heap
public class Heap {
    private int[] heap;
    private int size;
    private int capacity;
    private boolean isMaxHeap;

    // Constructor
    public Heap(int capacity, boolean isMaxHeap) {
        this.capacity = capacity;
        this.isMaxHeap = isMaxHeap;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Insert an element into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Remove the root element from the heap
    public int removeRoot() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1; 
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    // Display the heap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Heapify up to maintain heap property
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && compare(heap[index], heap[parent])) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    // Heapify down to maintain heap property
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int extremeIndex = index;

        if (leftChild < size && compare(heap[leftChild], heap[extremeIndex])) {
            extremeIndex = leftChild;
        }
        if (rightChild < size && compare(heap[rightChild], heap[extremeIndex])) {
            extremeIndex = rightChild;
        }
        if (extremeIndex != index) {
            swap(index, extremeIndex);
            heapifyDown(extremeIndex);
        }
    }

    // Compare two values based on heap type
    private boolean compare(int a, int b) {
        return isMaxHeap ? a > b : a < b;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
