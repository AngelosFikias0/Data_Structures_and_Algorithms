import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Prompt the user to choose between different options
        while (true) {
            System.out.println("What would you like to try? :\n1) Linked List \n2) Stack \n3) Queue \n4) BST \n5) Heap \n6) Hashtable \n7) QuickSort and BinarySearch");

            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > 7) {
                    System.out.println("Please enter a valid choice (1, 2, 3, 4, 5, 6, or 7):");
                } else {
                    break; // Exit loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        // Execute the corresponding functionality based on the user's choice
        switch (choice) {
            case 1:
                // Linked List functionality
                LinkedList list = new LinkedList();
                list.addFirst(10.0);
                list.addFirst(20.0);
                list.addLast(30.0);
                list.add(25.0, 2);
                System.out.println("List after adding elements:");
                list.traverseWholeList();
                System.out.println("\nDeleting first element: " + list.deleteFirst());
                System.out.println("List after deleting first element:");
                list.traverseWholeList();
                System.out.println("\nDeleting last element: " + list.deleteLast());
                System.out.println("List after deleting last element:");
                list.traverseWholeList();
                System.out.println("\nDeleting element at index 1: " + list.delete(1));
                System.out.println("List after deleting element at index 1:");
                list.traverseWholeList();
                System.out.println("\nElement at index 0:");
                list.traverseIndex(0);
                break;

            case 2:
                // Stack functionality
                Stack stack = new Stack(5);
                System.out.println("Pushing elements onto the stack:");
                stack.push(10.5);
                stack.push(20.0);
                stack.push(30.75);
                stack.push(40.25);
                stack.push(50.0);
                System.out.println("Attempting to push when stack is full:");
                stack.push(60.5);
                System.out.println("Peeking at the top element:");
                stack.peek();
                System.out.println("Popping elements from the stack:");
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                System.out.println("Attempting to pop when stack is empty:");
                stack.pop();
                System.out.println("Peeking at the top element when stack is empty:");
                stack.peek();
                break;

            case 3:
                // Queue functionality
                Queue queue = new Queue(5);
                System.out.println("Enqueuing elements:");
                queue.enqueue(10.5);
                queue.enqueue(20.3);
                queue.enqueue(30.7);
                queue.enqueue(40.9);
                queue.enqueue(50.1);
                System.out.println("Attempting to enqueue when queue is full:");
                queue.enqueue(60.2);
                System.out.println("Current queue:");
                queue.traverse();
                System.out.println("Dequeuing elements:");
                queue.dequeue();
                queue.dequeue();
                System.out.println("Queue after dequeue operations:");
                queue.traverse();
                System.out.println("Enqueuing more elements:");
                queue.enqueue(70.3);
                queue.enqueue(80.4);
                System.out.println("Final queue:");
                queue.traverse();
                break;

            case 4:
                // BST functionality
                BST bst = new BST();
                System.out.println("Inserting elements into the BST:");
                bst.insert(50);
                bst.insert(30);
                bst.insert(70);
                bst.insert(20);
                bst.insert(40);
                bst.insert(60);
                bst.insert(80);
                System.out.println("In-order traversal of the BST:");
                bst.inorder();
                System.out.println("\nSearching for element 40:");
                System.out.println(bst.search(40) ? "Element found" : "Element not found");
                System.out.println("\nDeleting element 70:");
                bst.delete(70);
                System.out.println("In-order traversal after deletion:");
                bst.inorder();
                System.out.println("\nSearching for element 70:");
                System.out.println(bst.search(70) ? "Element found" : "Element not found");
                break;

            case 5:
                // Heap functionality
                Heap heap = new Heap(10, true); // true for max-heap, false for min-heap
                System.out.println("Inserting elements into the heap:");
                heap.insert(50);
                heap.insert(30);
                heap.insert(70);
                heap.insert(20);
                heap.insert(40);
                heap.insert(60);
                heap.insert(80);
                System.out.println("Heap elements:");
                heap.display();
                System.out.println("\nRemoving root element:");
                System.out.println("Removed element: " + heap.removeRoot());
                System.out.println("Heap after removing root:");
                heap.display();
                System.out.println("\nInserting more elements:");
                heap.insert(90);
                heap.insert(10);
                System.out.println("Heap after inserting more elements:");
                heap.display();
                break;

            case 6:
                // Hash table functionality
                Hashtable<String, Integer> hashtable = new Hashtable<>(10);
                System.out.println("Inserting elements into the Hashtable:");
                hashtable.put("apple", 50);
                hashtable.put("banana", 30);
                hashtable.put("orange", 70);
                hashtable.put("grape", 20);
                hashtable.put("pear", 40);
                System.out.println("Hashtable elements:");
                hashtable.traverse();
                System.out.println("\nGetting value for key 'orange': " + hashtable.get("orange"));
                System.out.println("Updating value for key 'banana'");
                hashtable.put("banana", 35);
                System.out.println("Hashtable after update:");
                hashtable.traverse();
                System.out.println("\nRemoving key 'pear'");
                hashtable.remove("pear");
                System.out.println("Hashtable after removal:");
                hashtable.traverse();
                System.out.println("\nChecking if key 'apple' exists: " + hashtable.containsKey("apple"));
                System.out.println("Checking if key 'pear' exists: " + hashtable.containsKey("pear"));
                break;

            case 7:
                // QuickSort and BinarySearch functionality
                quickSortAndBinarySearch(scanner);
                break;
        }
    }

    // Method for QuickSort and BinarySearch functionality
    private static void quickSortAndBinarySearch(Scanner scanner) {
        System.out.println("Enter the size of the array:");
        int size = 0;
        while (true) {
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Size should be greater than 0. Please enter again:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        double[] array = new double[size];

        // Prompt the user to input the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    array[i] = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Sorting the array using QuickSort
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println("Sorted array:");
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Prompt the user to input a value to search in the array
        System.out.println("Enter the value to search:");
        double target = 0;
        while (true) {
            try {
                target = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        // Searching the value using BinarySearch
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(array, target, 0, array.length - 1);
        if (result != -1) {
            System.out.println("Value found at index: " + result);
        } else {
            System.out.println("Value not found in the array.");
        }
    }
}
