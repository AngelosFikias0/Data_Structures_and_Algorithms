// Class for linked list
public class LinkedList {
	Node head;
	Node tail;
	int size=0;
	
	// Initialization of the list
	LinkedList(){
		head=tail=null;
		size=0;
	}
	
	// Add node to the start of the list
	public void addFirst(double data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		if (size == 0){tail = node;}
        size++;
	}
	
	// Add node to the end of the list
	public void addLast(double data) {
		Node node = new Node(data);
		if(size==0){head = node;}else{tail.next = node;}
		tail = node;
		size++;
	}
	
	// Add node to specific index
	public void add(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node node = new Node(data);
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
	}
	
    // Delete the first node
    public double deleteFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node removedNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        } 
        size--;
        return removedNode.data;
    }

    // Delete the last node
    public double deleteLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            Node removedNode = head;
            head = null;
            tail = null;
            size--;
            return removedNode.data;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        Node removedNode = tail;
        tail = current;
        tail.next = null;
        size--;
        return removedNode.data;
    }

    // Delete a node at a specific index
    public double delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node removedNode = current.next;
        current.next = removedNode.next;
        size--;
        return removedNode.data;
    }

    // Traverse and print all elements in the list
    public void traverseWholeList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traverse and print element at a specific index
    public void traverseIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println(current.data);
    }
}
